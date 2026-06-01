package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {


    private final By TITLE = By.cssSelector("[data-test=title]");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final String REMOVE_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Remove']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы товаров")
    public ProductsPage open() {
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    @Override
    @Step("Ожидание появления тайтла на странице товаров'")
    public  ProductsPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Поиск тайтла Product на странице товаров")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Получение кнопки удаление товара для товара '{product}' ")
    public String getRemoveButton(String product) {
        return driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).getText();
    }

    @Step("Получение кнопки добавления товара для товара '{product}' ")
    public String getAddToCartButton(String product) {
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).getText();
    }

    @Step("Добавление продукта '{product}' в корзину")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Удаление продукта '{product}' из корзины")
    public ProductsPage removeProduct(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие кнопки перехода в корзину")
    public CartPage clickCart() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }
}
