package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingleProductPage extends BasePage {

    private final By PRODUCT_TITLE = By.cssSelector("[data-test=back-to-products]");

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Ожидание появления тайтла на странице Single Product Page'")
    public  SingleProductPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
        return this;
    }

    @Step("Поиск тайтла back-to-products для продукта на странице продукта")
    public String getTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }
}
