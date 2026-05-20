package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {


    private final By TITLE = By.cssSelector("[data-test=title]");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final String REMOVE_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Remove']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы товаров'")
    public void open() {
        driver.get(BASE_URL + "inventory.html");
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
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Удаление продукта '{product}' из корзины")
    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).click();
    }

    @Step("Нажатие кнопки перехода в корзину")
    public void clickCart() {
        driver.findElement(CART).click();
    }
}
