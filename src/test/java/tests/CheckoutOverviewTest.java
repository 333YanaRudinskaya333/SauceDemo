package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void finishOrder() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillOutAllFieldsAndContinue("Yana", "Rudzinskaya", "247787");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(checkoutCompletePage.getYourInformationTitle(), "Checkout: Complete!", "Checkout: Complete! title not found");
    }
}
