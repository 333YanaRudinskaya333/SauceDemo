package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductToCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        assertEquals(productsPage.getRemoveButton(product), "Remove", "Check Remove Button");
    }

    @Test
    public void removeProductFromCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.removeProduct(product);
        assertEquals(productsPage.getAddToCartButton(product), "Add to cart", "Check Remove Button");
    }
}
