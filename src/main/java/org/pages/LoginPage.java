package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginTextField;
    String loginTextFieldLocator = "//input[@name='login']";

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextField;
    String passwordTextFieldLocator = "//input[@name='password']";

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    String signInButtonLocator = "//button[@type='submit']";


    public LoginPage enterLogin(String login) {
        webDriverWait_10.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(loginTextFieldLocator))));
        clearAndEnterTextToElement(webDriver.findElement(By.xpath(loginTextFieldLocator)), login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clearAndEnterTextToElement(webDriver.findElement(By.xpath(passwordTextFieldLocator)), password);
        return this;
    }

    public LoginPage clickSignInButton() {
        clickOnElement(webDriver.findElement(By.xpath(signInButtonLocator)));
        return this;
    }


}
