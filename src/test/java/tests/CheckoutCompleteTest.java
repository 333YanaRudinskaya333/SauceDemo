package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void goBackHome() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillOutAllFieldsAndContinue("Yana", "Rudzinskaya", "247787");
        checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        assertEquals(productsPage.getTitle(), "Products", "title Products not found");
    }
}
