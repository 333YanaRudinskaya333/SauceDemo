package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
    public CartPage open() {
        log.info("Opening cart Page");
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    @Override
    @Step("Дождались отображения тайтла на странице после её загрузки")
    public CartPage isPageOpened() {
        log.info("Waiting for the title '{}' to appear on the cart page", CART_TITLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));
        return this;
    }

    @Step("Получение заголовка на странице корзины")
    public String getCartTitle() {
        log.info("Get Cart title on cart Page");
        return driver.findElement(CART_TITLE).getText();
    }

    @Step("Поиск добавленного товара в корзине корзины")
    public String findProductInCart(String product) {
        log.info("search for a product '{}' in the cart", product);
        return driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))).getText();
    }

    @Step("Нажатие на товар '{product}' в корзине")
    public CartPage clickOnTheProductInCart(String product) {
        log.info("search for a product '{}' in the cart", product);
        driver.findElement(By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие кнопки продолжить покупки в корзине")
    public ProductsPage clickContinueShopping() {
        log.info("Click continue shopping in the cart");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Нажатие кнопки оформления заказа")
    public CheckoutYourInformationPage clickCheckoutButton() {
        log.info("Click Checkout Button in the cart");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutYourInformationPage(driver);
    }

    @Step("Удаление продукта '{product}' из корзины на странице корзины")
    public CartPage removeFromCart(String product) {
        log.info("remove from cart product '{}' in the cart",product);
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Проверка удаления продукта '{product}' из корзины")
    public boolean isProductRemoved(String product) {
        log.info("checr is product '{}' remove from the cart",product);
        return driver.findElements(
                By.xpath(String.format(PRODUCT_IN_CART_PATTERN, product))
        ).isEmpty();
    }
}
