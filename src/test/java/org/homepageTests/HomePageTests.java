package org.homepageTests;

import org.baseTest.BaseTest;
import org.junit.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void T002_SignOutTest() {
        pageProvider.getHomePage()
                .openPage()
                .clickOnButtonSignInAndSwitchTab();
        pageProvider.getLoginPage()
                .logInAsValidUserAndSwitchTab()
                .checkIsRedirectedOnHomepage()
                .clickOnAvatarButton()
                .clickOnSignOutButton()
                .checkIsSignInButtonDisplayed();
        pageProvider.getHomePage()
                .checkIsAvatarButtonNotDisplayed();
    }
}
