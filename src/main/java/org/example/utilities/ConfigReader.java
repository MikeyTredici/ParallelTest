package org.example.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  private static String driverPathChrome;
  private static String driverPathFirefox;
  private static String retryCount;

  public ConfigReader() {
    FileInputStream fis;
    Properties properties = new Properties();
    try {
      fis = new FileInputStream("src\\main\\resources\\config.properties");
      properties.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Unable to read the config.properties file...");
      return;
    }

    driverPathChrome = properties.getProperty("chrome_driver_path");
    driverPathFirefox = properties.getProperty("firefox_driver_path");
    retryCount = properties.getProperty("retry_count");
  }

  public static String getDriverPathChrome() {
    return driverPathChrome;
  }

  public static String getDriverPathFirefox() {
    return driverPathFirefox;
  }

  public static String getRetryCount() {
    return retryCount;
  }
}
