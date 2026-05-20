package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test(testName = "Успешное завершение оформления товара",
            description = "Переход на страницу продуктов после успешного оформления товаров и нажатия кнопки Финиш",
            groups = {"regression"},
            retryAnalyzer = Retry.class)
    @Owner("Rudinskaya Y.V.")
    @Epic("Sause Demo 1")
    @Feature("Checkout Complete ")
    @Story("click Back Home on Checkout Checkout Complete and go to Products page")
    @Severity(SeverityLevel.MINOR)
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
