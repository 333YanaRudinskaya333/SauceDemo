package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void fiilOutYourInformationVithWalidData() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillOutAllFieldsAndContinue("Yana", "Rudzinskaya", "247787");
        assertEquals(checkoutOverviewPage.getOverviewTitle(), "Checkout: Overview", " Checkout: Overview title not found");
    }
}
