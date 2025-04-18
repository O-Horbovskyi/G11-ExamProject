package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.data.TestData.FEATS_SECTION_URL;
import static org.data.TestData.HOMEPAGE_URL;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//a[@class='login-status-sign-in btn btn-primary']")
    private WebElement signInButton;
    String signInButtonLocator = "//a[@class='login-status-sign-in btn btn-primary']";

    @FindBy(xpath = "//div[@class='btn dropdown-toggle']")
    private WebElement avatarButton;
    String avatarButtonLocator = "//div[@class='btn dropdown-toggle']";

    @FindBy(xpath = "//a[@onclick='WIKIDOT.page.listeners.logoutClick(event)']")
    private WebElement signOutButton;
    String signOutButtonLocator = "//a[@onclick='WIKIDOT.page.listeners.logoutClick(event)']";

    @FindBy(xpath = "//a[@href='https://www.wikidot.com/account/messages']")
    private WebElement messagesButton;
    String messagesButtonLocator = "//a[@href='https://www.wikidot.com/account/messages']";

    @FindBy(xpath = "//a[@href='http://dnd5e.wikidot.com/#toc70']")
    private WebElement featsSectionLink;
    String featsSectionLinkLocator = "//a[@href='http://dnd5e.wikidot.com/#toc70']";

    @FindBy(xpath = "//h1[@id='toc70']")
    private WebElement featsSectionTitle;
    String featsSectionTitleLocator = "//h1[@id='toc70']";

    @FindBy(xpath = "//a[@href='/feat:tavern-brawler']")
    private WebElement featsTavernBrawlerLink;
    String featsTavernBrawlerLinkLocator = "//a[@href='/feat:tavern-brawler']";

    @FindBy(xpath = "//div[@class='badge badge-info']")
    private WebElement newMessagesCounter;
    String newMessagesCounterLocator = "//div[@class='badge badge-info']";

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

    public void checkIsSignInButtonDisplayed() {
        Assert.assertTrue("Sign In button is not displayed", webDriver.findElement(By.xpath(signInButtonLocator)).isDisplayed());
        logger.info("Sign In button is displayed");
    }

    public void checkIsAvatarButtonNotDisplayed() {
        checkIsElementNotVisible(avatarButton);
        logger.info("Avatar button is not displayed");
    }

    public void clickOnButtonSignInAndSwitchTab() {
        clickOnElement(signInButtonLocator);
        logger.info("Button Sign In was clicked");
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        Assert.assertTrue("New tab did not open", tabs.size() > 1);
        webDriver.switchTo().window(tabs.get(1));

    }

    public HomePage clickOnAvatarButton() {
        clickOnElement(avatarButtonLocator);
        logger.info("Avatar button was clicked");
        return this;
    }

    public HomePage clickOnSignOutButton() {
        clickOnElement(signOutButtonLocator);
        logger.info("Sign Out button was clicked");
        return this;
    }

    public MessagesPage clickOnMessagesButton() {
        clickOnElement(messagesButtonLocator);
        logger.info("Messages button was clicked");
        return new MessagesPage(webDriver);
    }

    public HomePage clickOnFeatsSectionLink() {
        clickOnElement(featsSectionLinkLocator);
        logger.info("Feats section link was clicked");
        return this;
    }

    public HomePage checkIsFeatsSectionLink() {
        Assert.assertTrue("Feats section link is not displayed", webDriver.getCurrentUrl().matches(FEATS_SECTION_URL));
        return this;
    }

    public HomePage checkIsFeatsSectionTitleDisplayed() {
        webDriverWait_10.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(featsSectionTitleLocator))));
        checkIsElementVisible(featsSectionTitleLocator);
        logger.info("Feats section title is displayed");
        return this;
    }

    public void checkIsFeatsTavernBrawlerLinkDisplayed() {
        checkIsElementVisible(featsTavernBrawlerLinkLocator);
        logger.info("Feats Tavern Brawler link is displayed");
    }


    public void checkNewMessagesCounter(int numberOfMessages) {
        String messagesCounter = webDriver.findElement(By.xpath(newMessagesCounterLocator)).getText();
        Assert.assertTrue("Messages counter is not displayed", messagesCounter.contains(String.valueOf(numberOfMessages)));
        logger.info("Messages counter is displayed");
    }
}
