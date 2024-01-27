package org.playw.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginModal {
    public Locator loginUsernameTextBox;
    public Locator loginPasswordTextBox;
    public Locator loginButton;

    public LoginModal(Page page) {
        loginUsernameTextBox = page.locator("//input[@id='loginusername']");
        loginPasswordTextBox = page.locator("//input[@id='loginpassword']");
        loginButton = page.locator("//button[contains(text(),'Log in')]");
    }
}
