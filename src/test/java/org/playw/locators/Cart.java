package org.playw.locators;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Cart {

    public Locator totalPriceText;
    public Locator allDevicesInCart;
    public Locator placeOrderButton;

    public Cart(Page page) {
        totalPriceText = page.locator("//h3[@id='totalp']");
        allDevicesInCart = page.locator("//tbody/tr");
        placeOrderButton = page.locator("//button[contains(text(),'Place Order')]");
    }
}
