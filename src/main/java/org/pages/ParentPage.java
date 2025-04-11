package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends CommonActionsWithElements {

    private Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }


    protected void checkUrl(String url) {
        Assert.assertEquals("URL is not expected", url, webDriver.getCurrentUrl());
    }

}
