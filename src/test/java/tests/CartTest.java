package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test(testName = "Переход в пустую корзину",
            description = "Проверка возможнотсти перейти в пустую корзину",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Cart")
    @Story("Go to emty cart")
    @Description("Проверка возможнотсти перейти в пустую корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/") //ссылка на аналитику
    @TmsLink("SD-T01")
    @Issue("Bug-01")
    public void goToEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCart();
        assertEquals(cartPage.getCartTitle(), "Your Cart1", "Not found title \"Your Cart\" on page Cart");
    }


    @Test(testName = "Продолжить покупки из корзины",
            description = "Проверка возможнотсти продолжить покупки из корзины. В корзину ранее был добавлен товар",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Continue Shopping from Cart")
    @Story("click Continue Shopping in Cart and go to Products page")
    @Severity(SeverityLevel.MINOR)
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
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Checkout from Cart")
    @Story("click Checkout Button in Cart and go to Checkout page")
    @Severity(SeverityLevel.MINOR)
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
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Go to  single Product Cart from Cart")
    @Story("click On The Product InCart and go to single Product  page")
    @Severity(SeverityLevel.MINOR)
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
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Delete product from Cart")
    @Story("click On remove From Cart and stay in empty cart")
    @Severity(SeverityLevel.MINOR)
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
