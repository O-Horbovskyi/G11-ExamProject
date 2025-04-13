package org.pages;

import org.apache.log4j.Logger;
import org.data.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static org.data.TestData.HOMEPAGE_URL;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//a[@class='login-status-sign-in btn btn-primary']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='btn dropdown-toggle']")
    private WebElement avatarButton;
    String avatarButtonLocator = "//div[@class='btn dropdown-toggle']";

    public LoginPage clickSignInButton() {
        clickOnElement(signInButton);
        logger.info("Clicked on Sign In button");
        return new LoginPage(webDriver);
    }

    public HomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        logger.info("Login Page was opened with URL " + HOMEPAGE_URL);
        return this;
    }

    public HomePage checkIsRedirectedOnHomepage() {
        checkUrl(HOMEPAGE_URL);
        return this;
    }

    public void checkIsAvatarButtonDisplayed() {
        Assert.assertTrue("Avatar button is not displayed", webDriver.findElement(By.xpath(avatarButtonLocator)).isDisplayed());
        logger.info("Avatar button is displayed");
    }

    public void clickOnButtonSignIn() {
        webDriver.findElement(By.xpath("//a[@class='login-status-sign-in btn btn-primary']")).click();
        logger.info("Button Sign In was clicked");
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        Assert.assertTrue("New tab did not open", tabs.size() > 1);
        webDriver.switchTo().window(tabs.get(1));

    }



}
