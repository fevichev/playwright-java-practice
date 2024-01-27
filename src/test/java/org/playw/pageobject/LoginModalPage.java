package org.playw.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.browserconfiguration.BrowserConfig;

@Singleton
public class LoginModalPage {
    
    @Inject
    Page page;
    
    @Inject
    BrowserConfig bc;

    private final Locator loginUsernameTextBox = page.locator("//input[@id='loginusername']");
    private final Locator loginPasswordTextBox = page.locator("//input[@id='loginpassword']");
    private final Locator loginButton = page.locator("//button[contains(text(),'Log in')]");

    public void loginWithCredentials(String username, String password) {
        loginUsernameTextBox.fill(username);
        loginPasswordTextBox.fill(password);
        loginButton.click();
    }
}
