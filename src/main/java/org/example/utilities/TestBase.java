package org.example.utilities;

import org.example.pages.GooglePage;
import org.example.pages.NHLPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBase extends PageBase {
  private static final ConfigReader configReader = new ConfigReader();
  public WebDriver driver = null;
  public static String dockerUpCommand = "cmd /c start dockerUp.bat";
  public static String dockerDownCommand = "cmd /c start dockerDown.bat";
  public static String scaleCommand = "cmd /c start scaleChrome.bat";
  public static String dockerReady = "The node is registered to the hub and ready to use";
  public static String foundText = "Found text: ";
  public static String outputFile = "output.txt";
  public static String fileDeleted = "File deleted successfully";
  public static Runtime runtime = Runtime.getRuntime();
  public static GooglePage google = null;
  public static NHLPage nhl = null;

  @BeforeMethod
  public void setUp(ITestResult testResult) throws MalformedURLException {
    test = extent.createTest(testResult.getMethod().getMethodName());
    System.setProperty("webdriver.chrome.driver", ConfigReader.getDriverPathChrome());

    URL url = new URL("http://localhost:4444/wd/hub");
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    driver = new RemoteWebDriver(url, cap);

    driver.manage().window().setSize(new Dimension(1920, 1080));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    google = PageFactory.initElements(driver, GooglePage.class);
    nhl = PageFactory.initElements(driver, NHLPage.class);
  }

  @BeforeSuite
  public void initBase() throws IOException, InterruptedException {
    deleteOutput();
    dockerCommand(dockerUpCommand, dockerReady, foundText);
    scaleChrome(scaleCommand);

    initializeExtent();
  }

  @AfterTest
  public void dockerDown() throws IOException, InterruptedException {
    dockerCommand(dockerDownCommand, fileDeleted, foundText);
  }

  @AfterMethod
  public void closeAll(ITestResult testResult) throws IOException {
    try {
      PageBase.captureScreenshot(testResult, driver);
    } catch (AssertionError e) {
      e.printStackTrace();
      System.out.println("UI VALIDATION FAILED - NO SCREENSHOT");
    }

    extent.attachReporter();
    extent.flush();

    driver.manage().deleteAllCookies();
    driver.quit();
  }

  public void dockerCommand(String dockerStatus, String dockerReady, String foundText)
          throws IOException, InterruptedException {
    boolean flag = false;

    runtime.exec(dockerStatus);

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.SECOND, 45);
    long stop = cal.getTimeInMillis();
    Thread.sleep(3000);

    while (System.currentTimeMillis() < stop) {
      if (flag) {
        break;
      }

      BufferedReader reader = new BufferedReader(new FileReader(outputFile));
      String currentLine = reader.readLine();
      while (currentLine != null && !flag) {
        if (currentLine.contains(dockerReady)) {
          System.out.println(foundText + dockerReady);
          flag = true;
          break;
        }
        currentLine = reader.readLine();
      }
      reader.close();
    }

    Assert.assertTrue(flag);
  }

  public void scaleChrome(String scaleCommand) throws IOException, InterruptedException {
    runtime.exec(scaleCommand);
    Thread.sleep(5000);
  }

  public void deleteOutput() {
    File file = new File(outputFile);
    if (file.delete()) {
      System.out.println(fileDeleted);
    }
  }
}
