package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ParentPage extends CommonActionsWithElements {

    private Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }


    protected void checkUrl(String url) {
        Assert.assertEquals("URL is not expected", url, webDriver.getCurrentUrl());
    }

    public void switchToTab(int numberOfTab) {
        try {
            ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(numberOfTab));
            logger.info("Switched to new tab");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

}
