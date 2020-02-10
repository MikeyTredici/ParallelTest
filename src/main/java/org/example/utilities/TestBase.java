package org.example.utilities;

import org.example.pages.GooglePage;
import org.example.pages.NHLPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase extends PageBase {
  private static final ConfigReader configReader = new ConfigReader();
  public WebDriver driver = null;
  public static GooglePage google = null;
  public static NHLPage nhl = null;

  @BeforeMethod
  public void setUp(ITestResult testResult) {
    test = extent.createTest(testResult.getMethod().getMethodName());
    System.setProperty("webdriver.chrome.driver", ConfigReader.getDriverPathChrome());

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");

    driver = new ChromeDriver(options);

    driver.manage().window().setSize(new Dimension(1920, 1080));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    google = PageFactory.initElements(driver, GooglePage.class);
    nhl = PageFactory.initElements(driver, NHLPage.class);
  }

  @BeforeSuite
  public void initBase() {
    initializeExtent();
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
}
