package org.loginTests;

import org.baseTest.BaseTest;
import org.junit.Test;

import static org.data.TestData.VALID_LOGIN;
import static org.data.TestData.VALID_PASSWORD;

public class LoginTests extends BaseTest {
    @Test
    public void T001_ValidLoginTest() {
        pageProvider.getHomePage()
                .openPage()
                .clickOnButtonSignInAndSwitchTab();
        pageProvider.getLoginPage()
                .enterLogin(VALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickSignInButton()
                .switchToTab(0);
        pageProvider.getHomePage()
                .checkIsRedirectedOnHomepage()
                .checkIsAvatarButtonDisplayed()
        ;

    }

}
