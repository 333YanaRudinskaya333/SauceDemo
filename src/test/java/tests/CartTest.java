package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test(testName = "Переход в пустую корзину",
            description = "Проверка возможнотсти перейти в пустую корзину",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    public void goToEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCart();
        assertEquals(cartPage.getCartTitle(), "Your Cart", "Not found title \"Your Cart\" on page Cart");
    }


    @Test(testName = "Продолжить покупки из корзины",
            description = "Проверка возможнотсти продолжить покупки из корзины. В корзину ранее был добавлен товар",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    public void continueShoppingFromCart() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickContinueShopping();
        assertEquals(productsPage.getTitle(), "Products", "Products page title is incorrect");
    }

    @Test(testName = "Оформление заказа",
            description = "Проверка возможнотсти перейти на страницу оформления заказа из корзины с одним добавленным товаром",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
    public void checkoutWithOneProduct() {
        String product = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(product);
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutYourInformationPage.getYourInformationTitle(), "Checkout: Your Information", " not found Checkout: Your Information title on Checkout: Your Information Page");
    }

    @Test(testName = "Переход в карточку товара из корзины",
            description = "Проверка возможнотсти перейти в карточку товара из корзины",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    public void goToTheProductCardFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCart();
        cartPage.clickOnTheProductInCart("Sauce Labs Bike Light");
        assertEquals(singleProductPage.getTitle(), "Back to products", "Not found title \"Back to products\" on single Product Page");
    }

    @Test(testName = "Удалить товар из корзины",
            description = "Проверка возможнотсти удаления добаленного товара из корзины",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
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
