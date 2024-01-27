package org.playw.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Device {

    public Locator addToCartButton;
    public Locator devicePriceContainer;

    public Device(Page page) {
        addToCartButton = page.locator("//a[contains(text(),'Add to cart')]");
        devicePriceContainer = page.locator("//*[@id='tbodyid']/h3");
    }
}
