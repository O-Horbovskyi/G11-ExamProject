package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = "//a[@class='login-status-sign-in btn btn-primary']")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
        logger.info("Clicked on Sign In button");
    }


}
