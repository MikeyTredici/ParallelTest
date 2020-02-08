package org.example;

import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class NHLTest extends TestBase {
  public static final String nateMac = "Nathan MacKinnon";

  @Test
  public void nhlSearch() {
    System.out.println("Thread # " + Thread.currentThread().getId() + " nhlSearch");

    nhl.getUrlNHL();
    nhl.clickTopNavPlayers();
    nhl.searchForPlayer(nateMac);
  }
}
