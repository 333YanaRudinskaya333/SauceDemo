package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductPage extends BasePage {

    private final By PRODUCT_TITLE = By.cssSelector("[data-test=back-to-products]");

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }
}
