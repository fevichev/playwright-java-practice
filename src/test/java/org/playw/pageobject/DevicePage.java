package org.playw.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.browserconfiguration.BrowserConfig;
import org.play.utils.Utils;

@Singleton
public class DevicePage {

    @Inject
    private Utils utils;

    @Inject
    Page page;
    
    @Inject
    private BrowserConfig bc;

    public static final String PRODUCT_ADDED_ALERT_MESSAGE = "Product added.";
    public Locator addToCartButton = page.locator("//a[contains(text(),'Add to cart')]");
    public Locator devicePriceContainer = page.locator("//*[@id='tbodyid']/h3");


    public void moveDeviceToCart() {
        int price = Integer.parseInt(devicePriceContainer.textContent().split(" ")[0].
                replace("$", ""));
        utils.session.put("price", String.valueOf(price));
        addToCartButton.click();
    }

    public void verifyDeviceWasAddedToCart() {
//        assertThat(getTextOfAlert(), equalTo(PRODUCT_ADDED_ALERT_MESSAGE));
    }
}
