package org.playw.tests;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.play.browserconfiguration.BrowserConfig;
import org.playw.Base.Base;
import org.playw.pageobject.CartPage;
import org.playw.pageobject.DevicePage;
import org.playw.pageobject.HomePage;
import org.playw.pageobject.LoginModalPage;
import org.playw.pageobject.PlaceOrderModalPage;
import org.playw.pageobject.SignUpModalPage;
import org.play.utils.Utils;

@MicronautTest
public class UiApiDemoBlazeTest extends Base {
    @Inject
    Page page;

    @Inject
    Utils utils;

    @Inject
    HomePage homePage;

    @Inject
    SignUpModalPage signUpModalPage;

    @Inject
    LoginModalPage loginModalPage;

    @Inject
    DevicePage devicePage;

    @Inject
    CartPage cartPage;

    @Inject
    PlaceOrderModalPage placeOrderModalPage;

    @Inject
    Faker faker;

//    @Inject
//    BrowserConfig browserConfig;
//
//    @BeforeAll
//    public static void setup() {
//        BrowserConfig.launchBrowser();
//    }
//
//    @BeforeEach
//    public void contextSetup() {
//        browserConfig.createContextAndPage();
//        page.navigate("https://www.demoblaze.com");
//    }
//
    //    @Test(priority = 1, testName = "Create new user verification", groups = "UI")
    @Test
    @Order(1)
    void signUpTest() {
        page.navigate("https://www.demoblaze.com");

        String username = faker.internet().emailAddress();
        String password = faker.internet().password();
        utils.session.put("username", username);
        utils.session.put("password", password);

//        homePage.clickSignUpButton();
        signUpModalPage.populateUsernameAndPassword(username, password);
        signUpModalPage.verifyAlertMessage();
//        utils.acceptDialog();
    }

    //    @Test(priority = 2, testName = "Login to the system verification", groups = "UI")
    @Test
    @Order(2)
    void loginTest() {
        homePage.clickLoginTopMenuButton();
        loginModalPage.loginWithCredentials(utils.session.get("username"),
                utils.session.get("password"));
        homePage.verifyUserIsLoggedIn();
    }

    //    @Test(priority = 3, testName = "Add to cart 2 devices verification", groups = "UI")
    @Test
    @Order(3)
    void addToCartTest() {
        homePage.selectDeviceFromList("Nexus 6");
        devicePage.moveDeviceToCart();
        devicePage.verifyDeviceWasAddedToCart();
//        utils.acceptDialog();
        homePage.clickTopLogo();
        homePage.selectDeviceFromList("MacBook Pro");
        devicePage.moveDeviceToCart();
        devicePage.verifyDeviceWasAddedToCart();
//        utils.acceptDialog();
        homePage.clickTopLogo();
    }

    //    @Test(priority = 4, testName = "Move to Cart verification", groups = "UI")
    @Test
    @Order(4)
    void cartTest() {
        homePage.clickCartTopMenu();
        cartPage.verifyCartHasSelectedDevices();
        cartPage.verifyTotalPrice();
    }

    //    @Test(priority = 5, testName = "Place an order verification", groups = "UI")
    @Test
    @Order(5)
    void placeOrderTest() {
        cartPage.clickPlaceOrderButton();
        placeOrderModalPage.populateOrderFields();
        placeOrderModalPage.clickPurchaseButton();
        placeOrderModalPage.verifyOrderIsSubmitted();
        placeOrderModalPage.verifySubmittedFinalPrice();
        placeOrderModalPage.clickOkOnSubmissionModal();
    }

//    @Test(priority = 6, testName = "Login API test", groups = "API")
//    public void loginApiTest() {
//        homePage.clickTopLogo();
//        homePage.clickLoginTopMenuButton();
//        loginModalPage.loginWithCredentials(String.valueOf(utils.session.get("username")),
//                String.valueOf(utils.session.get("password")));
//        homePage.verifyUserIsLoggedIn();
//    }
//
//    @Test(priority = 7, testName = "Add device for API verification", groups = "API")
//    public void addDevice() {
//        homePage.selectDeviceFromList("Nexus 6");
//        devicePage.moveDeviceToCart();
//        devicePage.verifyDeviceWasAddedToCart();
//        getPage.acceptAlertMessage();
//        homePage.clickTopLogo();
//    }
//
//    @Test(priority = 8, testName = "Validate cart with API", groups = "API")
//    public void validateCartWithApi() {
//        homePage.clickCartTopMenu();
//        cartPage.verifyNumberOfItemsInTheCard(1);
//        cartPage.verifyPriceOfTheSelectedPhone(650);
//        cartPage.verifyTitleOfTheSelectedPhone("Nexus 6");
//        cartPage.verifyItemId(3);
//    }

    //    @AfterClass
    @AfterAll
    public static void teardown() {
//        browserConfig.closeContext();
        BrowserConfig.closeBrowser();
    }

    //    @AfterGroups(groups = {"UI"})
    public void cleanUp() {
//        cartPage.deleteCartApi();
//        homePage.clickLogOut();
    }
}
