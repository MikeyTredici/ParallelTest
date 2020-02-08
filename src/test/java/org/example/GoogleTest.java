package org.example;

import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {
  public static final String parallelTesting = "TestNG Parallel Testing";
  @Test
  public void googleSearch() {
    System.out.println("Thread # " + Thread.currentThread().getId() + " googleSearch");

    google.getUrlGoogle();
    google.searchGoogle(parallelTesting);
  }
}
