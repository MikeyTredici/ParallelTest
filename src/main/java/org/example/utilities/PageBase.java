package org.example.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageBase {
  public static ExtentReports extent;
  public static ExtentHtmlReporter html;
  public static ExtentTest test;
  public static ExtentTest imagePath;
  public static MediaEntityModelProvider mediaModel;
  private static final String dateFormat = "yyyyMMdd";
  private static final String reportFormat = ".html";
  private static final String imageFormat = ".png";
  private static final String errorValidationMessage = "Validation Failed...";

  // Initialize Tests
  public void initializeExtent() {
    boolean isInitialized = false;
    if (!isInitialized) {
      // Initialize Extent Report
      extent = new ExtentReports();
      html =
          new ExtentHtmlReporter(
              System.getProperty("user.dir") + "/src/main/resources/reports/parallelTest"
                  + new SimpleDateFormat(dateFormat).format(new Date())
                  + reportFormat);

      extent.attachReporter(html);

      isInitialized = true;

    } else {
      System.out.println("Extent Report is already initialized...");
    }
  }

  public static void captureScreenshot(ITestResult testResult, WebDriver driver) throws IOException {
    if (testResult.getStatus() == ITestResult.FAILURE) {
      // Take Screenshots Initialization
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String destPath = "src/main/resources/reports/screenshots/" + testResult.getName() + imageFormat;
      File destination = new File(destPath);
      FileUtils.copyFile(scrFile, destination);
      imagePath =
          test.addScreenCaptureFromPath("./screenshots/" + testResult.getName() + imageFormat);
      mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/" + testResult.getName() + imageFormat).build();
      test.fail(">>>", mediaModel);
      System.out.println(errorValidationMessage);
    }
  }
}
