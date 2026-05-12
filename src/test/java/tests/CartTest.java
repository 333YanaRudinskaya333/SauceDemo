package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void goToEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCart();
        assertEquals(cartPage.getCartTitle(), "Your Cart", "Not found title \"Your Cart\" on page Cart");
    }


    @Test
    public void continueShoppingFromCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickContinueShopping();
        assertEquals(productsPage.getTitle(), "Products", "Products page title is incorrect");
    }

    @Test
    public void checkoutWithOneProduct() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutYourInformationPage.getYourInformationTitle(), "Checkout: Your Information", " not found Checkout: Your Information title on Checkout: Your Information Page");
    }

    @Test
    public void goToTheProductCardFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();
        cartPage.clickOnTheProductInCart("Sauce Labs Bike Light");
        assertEquals(singleProductPage.getTitle(), "Back to products", "Not found title \"Back to products\" on single Product Page");
    }

    @Test
    public void removeProductFromCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.removeFromCart(product);
        assertTrue(cartPage.isProductRemoved(product));
    }
}
