package org.playw.pageobject;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.browserconfiguration.BrowserConfig;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Singleton
public class PlaceOrderModalPage {
    @Inject
    Faker faker;
    
    @Inject
    Page page;
    @Inject
    BrowserConfig bc;
    
    public Locator nameOrderTextBox = page.locator("//input[@id='name']");
    public Locator countryOrderTextBox = page.locator("//input[@id='country']");
    public Locator cityOrderTextBox = page.locator("//input[@id='city']");
    public Locator creditCardOrderTextBox = page.locator("//input[@id='card']");
    public Locator monthOrderTextBox = page.locator("//input[@id='month']");
    public Locator yearOrderTextBox = page.locator("//input[@id='year']");
    public Locator purchaseButton = page.locator("//button[contains(text(),'Purchase')]");
    public Locator thankYouText = page.locator("//h2[contains(text(),'Thank you for your purchase!')]");
    public Locator okOrderSubmitButton = page.locator("//button[contains(text(),'OK')]");
    public Locator orderDescriptionText = page.locator("//body/div[10]/p[1]");
    

    public void populateOrderFields() {
        String name = faker.funnyName().name();
        String country = faker.country().countryCode2();
        String city = faker.address().city();
        String creditCard = faker.finance().creditCard();
        String month = faker.rickAndMorty().character();
        String year = faker.number().digits(4);

        nameOrderTextBox.fill(name);
        countryOrderTextBox.fill(country);
        cityOrderTextBox.fill(city);
        creditCardOrderTextBox.fill(creditCard);
        monthOrderTextBox.fill(month);
        yearOrderTextBox.fill(year);
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    public void verifyOrderIsSubmitted() {
        assertThat(thankYouText).isVisible();
        assertThat(okOrderSubmitButton).isVisible();
    }

    public void verifySubmittedFinalPrice() {
        int summaryTotalPrice = Integer.parseInt(orderDescriptionText.textContent().split("\n")[1].
                split(" ")[1]);
//        assertThat(getExpectedTotalPrice(priceValues), equalTo(summaryTotalPrice));
    }

    public void clickOkOnSubmissionModal() {
        okOrderSubmitButton.click();
    }

    private int getExpectedTotalPrice(List<Integer> prices) {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }
}
