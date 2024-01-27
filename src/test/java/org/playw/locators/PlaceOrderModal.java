package org.playw.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PlaceOrderModal {

    public Locator nameOrderTextBox;
    public Locator countryOrderTextBox;
    public Locator cityOrderTextBox;
    public Locator creditCardOrderTextBox;
    public Locator monthOrderTextBox;
    public Locator yearOrderTextBox;
    public Locator purchaseButton;
    public Locator thankYouText;
    public Locator okOrderSubmitButton;
    public Locator orderDescriptionText;

    public PlaceOrderModal(Page page) {
        nameOrderTextBox = page.locator("//input[@id='name']");
        countryOrderTextBox = page.locator("//input[@id='country']");
        cityOrderTextBox = page.locator("//input[@id='city']");
        creditCardOrderTextBox = page.locator("//input[@id='card']");
        monthOrderTextBox = page.locator("//input[@id='month']");
        yearOrderTextBox = page.locator("//input[@id='year']");
        purchaseButton = page.locator("//button[contains(text(),'Purchase')]");
        thankYouText = page.locator("//h2[contains(text(),'Thank you for your purchase!')]");
        okOrderSubmitButton = page.locator("//button[contains(text(),'OK')]");
        orderDescriptionText = page.locator("//body/div[10]/p[1]");
    }
}
