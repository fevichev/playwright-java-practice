package org.playw.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.play.browserconfiguration.BrowserConfig;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Singleton
public class CartPage {
    @Inject
    private BrowserConfig bc;
    
    @Inject
    Page page;

    public Locator totalPriceText = page.locator("//h3[@id='totalp']");
    public Locator allDevicesInCart = page.locator("//tbody/tr");
    public Locator placeOrderButton = page.locator("//button[contains(text(),'Place Order')]");

    public void verifyCartHasSelectedDevices() {
//        assertThat(getExpectedTotalPrice(priceValues), equalTo(Integer.parseInt(element(totalPriceText).getText())));
        assertThat(allDevicesInCart).hasCount(2);
    }

    public void verifyTotalPrice() {
//        Map<String, Integer> expectedValueInCart = Map.of("Nexus 6", 650, "MacBook Pro", 1100);
//        Map<String, Integer> actualValuesInCart = new HashMap<>();
//        for (WebElement row : elements(allDevicesInCart)) {
//            String deviceNameInCart = row.findElements(By.tagName("td")).get(1).getText();
//            int devicePriceInCart = Integer.parseInt(row.findElements(By.tagName("td")).get(2).getText());
//            actualValuesInput(deviceNameInCart, devicePriceInCart);
//        }
//        assertThat(expectedValueInentrySet(), everyItem(is(in(actualValuesInentrySet()))));
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

//    public void verifyNumberOfItemsInTheCard(int expectedItemsNumber) {
//        int numberOfItemsInCart = ViewCartApi.withToken(getUserTokenApi()).getSizeOfItemsInCart();
//        assertThat(numberOfItemsInCart, equalTo(expectedItemsNumber));
//    }
//
//    public void verifyPriceOfTheSelectedPhone(int expectedItemPrice) {
//        int price = ViewDeviceDescriptionApi.withDeviceId(getProductIdInCart()).getPrice();
//        assertThat(price, equalTo(expectedItemPrice));
//    }
//
//    public void verifyTitleOfTheSelectedPhone(String expectedPhoneTitle) {
//        String deviceName = ViewDeviceDescriptionApi.withDeviceId(getProductIdInCart()).getTitle();
//        assertThat(deviceName, equalTo(expectedPhoneTitle));
//    }

//    public void verifyItemId(int expectedId) {
//        assertThat(getProductIdInCart(), equalTo(expectedId));
//    }

//    public void deleteCartApi() {
//        DeleteCartAPI.withCredentials(String.valueOf(session.get("username")));
//    }

    private int getExpectedTotalPrice(List<Integer> prices) {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }

//    private String getUserTokenApi() {
//        return LoginApi.withCredentials(String.valueOf(utils.session.get("username")),
//                String.valueOf(utils.session.get("password"))).getAuth_token();
//    }
//
//    private int getProductIdInCart() {
//        return ViewCartApi.withToken(getUserTokenApi()).getProductId();
//    }
}
