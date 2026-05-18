package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(testName = "Добавление продукта в корзину",
            description = "Добавление продукта в корзину",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
    public void addProductToCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        assertEquals(productsPage.getRemoveButton(product), "Remove", "Check Remove Button");
    }

    @Test(testName = "Удаление продукта из корзины на странице продуктов",
            description = "даление продукта из корзины на странице продуктов",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
    public void removeProductFromCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.removeProduct(product);
        assertEquals(productsPage.getAddToCartButton(product), "Add to cart", "Check Remove Button");
    }
}
