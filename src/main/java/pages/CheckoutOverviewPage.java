package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Step("Нажатие кнопки завершения оформления заказа")
    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
