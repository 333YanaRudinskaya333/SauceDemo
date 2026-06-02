package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SingleProductPage extends BasePage {

    private final By PRODUCT_TITLE = By.cssSelector("[data-test=back-to-products]");

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Ожидание появления тайтла на странице Single Product Page'")
    public  SingleProductPage isPageOpened(){
        log.info("Waiting for the title '{}' to appear on the Single Product Page", PRODUCT_TITLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
        return this;
    }

    @Step("Поиск тайтла back-to-products для продукта на странице продукта")
    public String getTitle() {
        log.info("Looking for the title '{}' to appear on the Single Product Page", PRODUCT_TITLE);
        return driver.findElement(PRODUCT_TITLE).getText();
    }
}
