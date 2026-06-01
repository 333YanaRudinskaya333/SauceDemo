package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(testName = "Оформление заказа",
            description = "Переход на страницу оформления заказа и ввод личных данных, переход на страницу завершения оформления товара",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Enter personal data on Page Checkout your information")
    @Story("Go to the checkout Your Information page and enter your personal information, then go to the checkout Overview page")
    @Severity(SeverityLevel.MINOR)
    public void fillOutYourInformationWithWalidData() {
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
