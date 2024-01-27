package org.playw.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Home {

    public Locator signUpButton;
    public Locator loginTopMenuButton;
    public Locator logoutTopMenuButton;
    public Locator nameOfUser;
    public Locator nextPageButton;
    public Locator mainLogoButton;
    public Locator cartTopMenuButton;
    public Home(Page page) {
        signUpButton = page.locator("signin2");
        loginTopMenuButton = page.locator("#login2");
        logoutTopMenuButton = page.locator("//a[@id='logout2']");
        nameOfUser = page.locator("//a[@id='nameofuser']");
        nextPageButton = page.locator("//button[@id='next2']");
        mainLogoButton = page.locator("//a[@id='nava']");
        cartTopMenuButton = page.locator("//a[contains(text(),'Cart')]");
    }

}