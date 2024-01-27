package org.playw.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.utils.Utils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Singleton
public class HomePage {
    @Inject
    Utils utils;
    
    @Inject
    Page page;

    Locator signUpButton = page.locator("#signin2");
    Locator loginTopMenuButton = page.locator("#login2");
    Locator logoutTopMenuButton = page.locator("//a[@id='logout2']");
    Locator nameOfUser = page.locator("//a[@id='nameofuser']");
    Locator nextPageButton = page.locator("//button[@id='next2']");
    Locator mainLogoButton = page.locator("//a[@id='nava']");
    Locator cartTopMenuButton = page.locator("//a[contains(text(),'Cart')]");

    public Locator deviceWithName(String deviceName) {
        return page.locator("//a[contains(text(),'" + deviceName + "')]");
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void clickLoginTopMenuButton() {
        loginTopMenuButton.click();
    }

    public void verifyUserIsLoggedIn() {
        assertThat(nameOfUser).containsText(utils.session.get("username"));
    }

    public void selectDeviceFromList(String deviceName) {
        try {
            deviceWithName(deviceName).click();
        } catch (Exception e) {
            nextPageButton.click();
            deviceWithName(deviceName).click();
        }
    }

    public void clickTopLogo() {
        mainLogoButton.click();
    }

    public void clickLogOut() {
        logoutTopMenuButton.click();
    }

    public void clickCartTopMenu() {
        cartTopMenuButton.click();
    }
}