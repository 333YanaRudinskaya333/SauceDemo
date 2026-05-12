package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final By COMPLETE_TITLE = By.cssSelector("[data-test=title]");
    private final By BACK_HOME_BUTTON = By.cssSelector("[data-test=back-to-products]");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getYourInformationTitle() {
        return driver.findElement(COMPLETE_TITLE).getText();
    }

    public void clickBackHomeButton () {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
