package org.example.pages;

import org.example.utilities.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(name = "q")
    private WebElement googleSearch;

    public void getUrlGoogle() {
        driver.get("https://google.com");
    }

    public void searchGoogle(String query) {
        wait.until(ExpectedConditions.visibilityOf(googleSearch));
        googleSearch.clear();
        googleSearch.sendKeys(query);
        googleSearch.sendKeys(Keys.ENTER);

        test.info("Searching for: " + query);
    }
}
