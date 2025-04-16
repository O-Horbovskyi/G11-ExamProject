package org.messageTests;

import org.baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

import static org.data.TestData.MESSAGE_SUBJECT;
import static org.data.TestData.MESSAGE_TEXT;

public class MessageTests extends BaseTest {

    @Test
    public void T003_MessageSentTest() {
        pageProvider.getHomePage()
                .openPage()
                .clickOnButtonSignInAndSwitchTab();
        pageProvider.getLoginPage()
                .logInAsValidUserAndSwitchTab()
                .clickOnAvatarButton()
                .clickOnMessagesButton()
                .clickOnNewMessageButton()
                .clickOnUserInfoButton()
                .clickOnWritePrivateMessageButton()
                .enterSubject(MESSAGE_SUBJECT)
                .enterMessage(MESSAGE_TEXT)
                .clickOnSendButton()
                .checkIsMessagesAreSent(MESSAGE_TEXT, MESSAGE_SUBJECT, 1);

    }

    @After
    public void deleteMessage() {
        pageProvider.getMessagePage().deleteNewMessages(MESSAGE_TEXT, MESSAGE_SUBJECT).checkIsNewMessageWereDeleted(MESSAGE_TEXT, MESSAGE_SUBJECT);
    }


}
