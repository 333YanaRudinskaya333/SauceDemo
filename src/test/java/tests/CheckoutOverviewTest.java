package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewTest extends BaseTest {

    @Test(testName = "Оформление заказа",
            description = "Переход на страницу оформления заказа и ввод личных данных, переход на страницу завершения оформления товара",
            groups = {"regression", "smoke"},
            retryAnalyzer = Retry.class)
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Go to Checkout Overview Page")
    @Story("click Finish Button on Checkout Overview Page")
    @Severity(SeverityLevel.MINOR)
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
