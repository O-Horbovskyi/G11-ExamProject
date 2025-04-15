package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MessagesPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    public MessagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='awesome  grey btn btn-primary']")
    private WebDriver newMessageButton;
    String newMessageButtonLocator = "//a[@class='awesome  grey btn btn-primary']";

    @FindBy(xpath = "//span[@class='printuser avatarhover']")
    private WebDriver userInfoButton;
    String userInfoButtonLocator = "//span[@class='printuser avatarhover']";

    @FindBy(xpath = "//a[@href='http://www.wikidot.com/account/messages#/new/9646878']")
    private WebDriver writePrivateMessageButton;
    String writePrivateMessageButtonLocator = "//a[@href='http://www.wikidot.com/account/messages#/new/9646878']";

    @FindBy(xpath = "//input[@id='pm-subject']")
    private WebDriver subjectInput;
    String subjectInputLocator = "//input[@id='pm-subject']";

    @FindBy(xpath = "//textarea[@id='editor-textarea']")
    private WebDriver messageInput;
    String messageInputLocator = "//textarea[@id='editor-textarea']";

    @FindBy(xpath = "//input[@value='Send']")
    private WebDriver sendButton;
    String sendButtonLocator = "//input[@value='Send']";

    @FindBy(xpath = "//button[@class='red btn btn-xs btn-danger']")
    private WebDriver deleteMessagesButton;
    String deleteMessagesButtonLocator = "//button[@class='red btn btn-xs btn-danger']";

    @FindBy(xpath = "//a[@class='btn btn-default button button-remove-message']")
    private WebDriver removeMessageButton;
    String removeMessageButtonLocator = "//a[@class='btn btn-default button button-remove-message']";

    private String inboxMessagesSubjectLocator = "//span[text()='%s'][@class='subject']";
    private String inboxMessagesPreviewLocator = "//span[text()='%s'][@class='preview']";
    private String inboxMessagesCheckboxLocator = "//tr[@class='message new' and .//span[text()='%s']]/td/input[@type='checkbox']";

    // //span[text()="TestMessage"][@class="subject"]
    // class="preview"






}
