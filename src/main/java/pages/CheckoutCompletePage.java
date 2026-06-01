package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage {
    private final By COMPLETE_TITLE = By.cssSelector("[data-test=title]");
    private final By BACK_HOME_BUTTON = By.cssSelector("[data-test=back-to-products]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка на старице CheckoutComplete ")
    public String getYourInformationTitle() {
        return driver.findElement(COMPLETE_TITLE).getText();
    }

    @Override
    @Step("Открыта страница Checkout Complete")
    public CheckoutCompletePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE_TITLE));
        return this;
    }

    @Step("Нажатие кнопки для возврата на страницу товаров")
    public ProductsPage clickBackHomeButton () {
        driver.findElement(BACK_HOME_BUTTON).click();
        return new ProductsPage(driver);
    }
}
