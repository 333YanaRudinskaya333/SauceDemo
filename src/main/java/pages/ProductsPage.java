package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
        log.info("Opening Products Page");
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    @Override
    @Step("Ожидание появления тайтла на странице товаров'")
    public  ProductsPage isPageOpened(){
        log.info("Waiting for the title '{}' to appear on the Products Page", TITLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Поиск тайтла Product на странице товаров")
    public String getTitle() {
        log.info("Getting for the title '{}'  on the Product page", TITLE);
        return driver.findElement(TITLE).getText();
    }

    @Step("Получение кнопки удаление товара для товара '{product}' ")
    public String getRemoveButton(String product) {
        log.info("Getting Remove Button '{}'  on the Product page", REMOVE_PATTERN);
        return driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).getText();
    }

    @Step("Получение кнопки добавления товара для товара '{product}' ")
    public String getAddToCartButton(String product) {
        log.info("Getting Add To Cart Button '{}'  on the Product page", ADD_TO_CART_PATTERN);
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).getText();
    }

    @Step("Добавление продукта '{product}' в корзину")
    public ProductsPage addToCart(String product) {
        log.info("Adding To Cart product '{}'  on the Product page", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Удаление продукта '{product}' из корзины")
    public ProductsPage removeProduct(String product) {
        log.info("Removing from Cart product '{}'  on the Product page", product);
        driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие кнопки перехода в корзину")
    public CartPage clickCart() {
        log.info("click Cart button on the Product page");
        driver.findElement(CART).click();
        return new CartPage(driver);
    }
}
