package org.playw.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SignUpModalPage {
    @Inject
    Page page;
    
    public static final String ALERT_MESSAGE = "Sign up successful.";
    public Locator usernameTextBox = page.locator("#sign-username");
    public Locator passwordTextBox = page.locator("#sign-password");
    public Locator signUpButtonModal = page.locator("//button[contains(text(),'Sign up')]");

    public void populateUsernameAndPassword(String username, String password) {
        usernameTextBox.fill(username);
        passwordTextBox.fill(password);
        signUpButtonModal.click();
    }

    public void verifyAlertMessage() {
//        assertThat(getTextOfAlert(), equalTo(ALERT_MESSAGE));
    }
}