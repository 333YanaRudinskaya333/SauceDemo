package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutOverviewPage extends BasePage {
    private final By OVERVIEW_TITLE = By.cssSelector("[data-test=title]");
    private final By FINISH_BUTTON = By.cssSelector("[data-test=finish]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка на странице Checkout Overview Page")
    public String getOverviewTitle() {
        log.info("Waiting for the title '{}'  on the Overview Page", OVERVIEW_TITLE);
        return driver.findElement(OVERVIEW_TITLE).getText();
    }

    @Override
    @Step("Открыта страница Overview Page")
    public CheckoutOverviewPage isPageOpened() {
        log.info("Waiting for the title '{}' to appear on the Overview page", OVERVIEW_TITLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(OVERVIEW_TITLE));
        return this;
    }

    @Step("Нажатие кнопки завершения оформления заказа")
    public CheckoutCompletePage clickFinishButton() {
        log.info("click Finish button  on the Overview page");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
