package org.playw.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpModal {
    public Locator usernameTextBox;
    public Locator passwordTextBox;
    public Locator signUpButtonModal;

    public SignUpModal(Page page) {
        usernameTextBox = page.locator("#sign-username");
        passwordTextBox = page.locator("#sign-password");
        signUpButtonModal = page.locator("//button[contains(text(),'Sign up')]");
    }
}