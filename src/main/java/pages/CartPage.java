package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CART_TITLE = By.cssSelector("[data-test=title]");
    private final String PRODUCT_IN_CART_PATTERN = "//div[@data-test='inventory-item-name' and normalize-space(text())='%s']/ancestor::a";
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("[data-test=continue-shopping]");
    private final By CHECKOUT_BUTTON = By.cssSelector("[data-test=checkout]");
    private final String REMOVE_FROM_CART_PATTERN = "//*[normalize-space(text())='%s']" +
            "//ancestor::div[contains(@class,'cart_item')]" +
            "//button[normalize-space(text())='Remove']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу корзины")
    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    @Step("Получение заголовка на странице корзины")
    public String getCartTitle() {
        return driver.findElement(CART_TITLE).getText();
    }

    @Step("Поиск добавленного товара в корзине корзины")
    public String findProductInCart(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))).getText();
    }

    @Step("Нажатие на товар '{product}' в корзине")
    public void clickOnTheProductInCart(String product) {
        driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))).click();
    }

    @Step("Нажатие кнопки продолжить покупки в корзине")
    public void clickContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Нажатие кнопки оформления заказа")
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Удаление продукта '{product}' из корзины на странице корзины")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
    }

    @Step("Проверка удаления продукта '{product}' из корзины")
    public boolean isProductRemoved(String product) {
        return driver.findElements(
                By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))
        ).isEmpty();
    }
}
