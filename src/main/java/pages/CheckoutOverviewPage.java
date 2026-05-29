package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {
    private final By OVERVIEW_TITLE = By.cssSelector("[data-test=title]");
    private final By FINISH_BUTTON = By.cssSelector("[data-test=finish]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка на странице Checkout Overview Page")
    public String getOverviewTitle() {
        return driver.findElement(OVERVIEW_TITLE).getText();
    }

    @Override
    @Step("Открыта страница Overview Page")
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OVERVIEW_TITLE));
        return this;
    }

    @Step("Нажатие кнопки завершения оформления заказа")
    public CheckoutCompletePage clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
