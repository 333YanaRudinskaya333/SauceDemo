package pages;

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

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getRemoveButton(String product) {
        return driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).getText();
    }

    public String getAddToCartButton(String product) {
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).getText();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_PATTERN, product))).click();
    }

    public void clickCart() {
        driver.findElement(CART).click();
    }
}
