package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.utils.Utils_Custom;

import java.util.List;

public class MessagesPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    public MessagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='awesome  grey btn btn-primary']")
    private WebElement newMessageButton;
    String newMessageButtonLocator = "//a[@class='awesome  grey btn btn-primary']";

    @FindBy(xpath = "//span[@class='printuser avatarhover']")
    private WebElement userInfoButton;
    String userInfoButtonLocator = "//span[@class='printuser avatarhover']";

    @FindBy(xpath = "//a[@href='http://www.wikidot.com/account/messages#/new/9646878']")
    private WebElement writePrivateMessageButton;
    String writePrivateMessageButtonLocator = "//a[@href='http://www.wikidot.com/account/messages#/new/9646878']";

    @FindBy(xpath = "//input[@id='pm-subject']")
    private WebElement subjectInput;
    String subjectInputLocator = "//input[@id='pm-subject']";

    @FindBy(xpath = "//textarea[@id='editor-textarea']")
    private WebElement messageInput;
    String messageInputLocator = "//textarea[@id='editor-textarea']";

    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendButton;
    String sendButtonLocator = "//input[@value='Send']";

    @FindBy(xpath = "//button[@class='red btn btn-xs btn-danger']")
    private WebElement deleteMessagesButton;
    String deleteMessagesButtonLocator = "//button[@class='red btn btn-xs btn-danger']";

    @FindBy(xpath = "//a[@class='btn btn-default button button-remove-message']")
    private WebElement removeMessageButton;
    String removeMessageButtonLocator = "//a[@class='btn btn-default button button-remove-message']";

    @FindBy(xpath = "//div[@class='odialog-shader']")
    private WebElement popupMessage;
    String popupMessageLocator = "//div[@class='odialog-shader']";

    private String inboxMessagesLocator = "//td[span[normalize-space(text())='%s'] and span[text()='%s']]";
    private String inboxMessagesCheckboxLocator = "//tr[@class='message new' and .//span[text()='%s']]/td/input[@type='checkbox']";

    public MessagesPage clickOnNewMessageButton() {
        clickOnElement(newMessageButtonLocator);
        logger.info("Clicked on New Message button");
        return this;
    }

    public MessagesPage clickOnUserInfoButton() {
        clickOnElement(userInfoButtonLocator);
        logger.info("Clicked on User Info button");
        return this;
    }

    public MessagesPage clickOnWritePrivateMessageButton() {
        clickOnElement(writePrivateMessageButtonLocator);
        logger.info("Clicked on Write Private Message button");
        return this;
    }

    public MessagesPage enterSubject(String subject) {
        clearAndEnterTextToElement(subjectInputLocator, subject);
        logger.info("Entered subject: " + subject);
        return this;
    }

    public MessagesPage enterMessage(String message) {
        clearAndEnterTextToElement(messageInputLocator, message);
        logger.info("Entered message: " + message);
        return this;
    }

    public MessagesPage clickOnSendButton() {
        clickOnElement(sendButtonLocator);
        logger.info("Clicked on Send button");
        return this;
    }

    public void checkIsMessagesAreSent(String subject, String message, int numberOfMessages) {
        Assert.assertEquals("Number of messages is not expected", numberOfMessages, getListOfNewMessages(subject, message).size());
    }


    public List<WebElement> getListOfNewMessages(String message, String subject) {
        return webDriver.findElements(By.xpath(String.format(inboxMessagesLocator, message, subject)));
    }

    public MessagesPage deleteNewMessages(String message, String subject) {
        List<WebElement> listOfNewMessages = getListOfNewMessages(message, subject);
        final int MAX_NEW_MESSAGES_COUNT = 100;
        int count = 0;
        while (!listOfNewMessages.isEmpty() && (count < MAX_NEW_MESSAGES_COUNT)) {
            webDriverWait_10.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath(popupMessageLocator))));
            clickOnElement(webDriver.findElement(By.xpath(String.format(inboxMessagesCheckboxLocator, subject))));
            clickOnElement(deleteMessagesButtonLocator);
            clickOnElement(removeMessageButtonLocator);
            webDriverWait_10.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath(popupMessageLocator))));
            listOfNewMessages = getListOfNewMessages(message, subject);
            count++;
            logger.info("Deleted message with subject: " + subject);
        }
        if (MAX_NEW_MESSAGES_COUNT == count) {
            logger.error("Number of posts more than " + MAX_NEW_MESSAGES_COUNT);
        }
        return this;
    }

    public void checkIsNewMessageWereDeleted(String message, String subject) {
        checkIsElementNotVisible(webDriver.findElements(By.xpath(String.format(inboxMessagesLocator, message, subject))));
        logger.info("New message was deleted");
    }


}
