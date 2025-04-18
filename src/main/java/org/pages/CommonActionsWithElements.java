package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait_10, webDriverWait_15;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait_15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    private String getElementName(WebElement webElement) {
        String elementName;
        try {
            elementName = webElement.getAccessibleName();
        } catch (Exception e) {
            elementName = "";
        }
        return elementName;
    }

    public void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element " + webElement + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(String xpath) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            String elementName = webElement.getAccessibleName();
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element " + elementName + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clearAndEnterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into element" + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clearAndEnterTextToElement(String xpath, String text) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into element" + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectCheckbox(WebElement webElement) {
        try {
            if (!webElement.isSelected()) {
                webElement.click();
                logger.info("Checkbox " + getElementName(webElement) + " was selected");
            } else {
                logger.info("Checkbox " + getElementName(webElement) + " is already selected");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public boolean isElementVisible(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element " + getElementName(webElement) + " is visible");
            } else {
                logger.info("Element " + getElementName(webElement) + " is not visible");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not found");
            return false;
        }
    }

    protected void checkIsElementVisible(WebElement webElement) {
        Assert.assertTrue("Element is not visible", isElementVisible(webElement));
    }

    protected void checkIsElementVisible(String locator) {
        Assert.assertTrue("Element is not visible", isElementVisible(webDriver.findElement(By.xpath(locator))));
    }

    protected void checkIsElementNotVisible(WebElement webElement) {
        Assert.assertFalse("Element is visible", isElementVisible(webElement));
    }

    protected void checkIsElementNotVisible(List<WebElement> webElements) {
        Assert.assertTrue("Element is visible", webElements.isEmpty());
    }

}
