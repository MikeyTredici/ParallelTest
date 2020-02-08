package org.example.pages;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NHLPage extends PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public NHLPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//li[@class='top-nav__primary__menu__item top-nav__primary__menu__item--players']")
    private WebElement topNavPlayers;

    @FindBy(xpath = "//div[@class='title-banner__navigation title-banner__navigation--padded']/form/input")
    private WebElement playersSearch;

    public void getUrlNHL() {
        driver.get("http://nhl.com");
    }

    public void clickTopNavPlayers() {
        wait.until(ExpectedConditions.elementToBeClickable(topNavPlayers));
        topNavPlayers.click();

        test.info("Clicked on Players in the Top Nav Bar");
    }

    public void  searchForPlayer(String playerName) {
        wait.until(ExpectedConditions.visibilityOf(playersSearch));
        playersSearch.clear();
        playersSearch.sendKeys(playerName);

        test.info("Searched for player: " + playerName);
    }
}
