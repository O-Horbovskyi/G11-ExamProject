package org.homepageTests;

import org.baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

import static org.data.TestData.MESSAGE_SUBJECT;
import static org.data.TestData.MESSAGE_TEXT;

public class MessageCounterTest extends BaseTest {

    @Test
    public void T006_NewMessagesCounterTest() {
        pageProvider.getHomePage()
                .openPage()
                .clickOnButtonSignInAndSwitchTab();
        pageProvider.getLoginPage()
                .logInAsValidUserAndSwitchTab()
                .checkIsRedirectedOnHomepage()
                .clickOnAvatarButton()
                .clickOnMessagesButton()
                .clickOnNewMessageButton()
                .clickOnUserInfoButton()
                .clickOnWritePrivateMessageButton()
                .enterSubject(MESSAGE_SUBJECT)
                .enterMessage(MESSAGE_TEXT)
                .clickOnSendButton();
        pageProvider.getHomePage()
                .openPage()
                .checkNewMessagesCounter(1);
    }

    @After
    public void deleteMessage() {
        pageProvider.getHomePage()
                .clickOnAvatarButton()
                .clickOnMessagesButton();
        pageProvider.getMessagePage().deleteNewMessages(MESSAGE_TEXT, MESSAGE_SUBJECT).checkIsNewMessageWereDeleted(MESSAGE_TEXT, MESSAGE_SUBJECT);
    }
}
