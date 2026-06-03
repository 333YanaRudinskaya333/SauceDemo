package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutYourInformationPage extends BasePage {
    private final By YOUR_INFORMATION_TITLE = By.cssSelector("[data-test=title]");
    private final By FIRST_NAME = By.cssSelector("[data-test=firstName]");
    private final By LAST_NAME = By.cssSelector("[data-test=lastName]");
    private final By ZIP_CODE = By.cssSelector("[data-test=postalCode]");
    private final By CONTINUE_BUTTON = By.cssSelector("[data-test=continue]");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public String getYourInformationTitle() {
        log.info("Waiting for the title '{}'  on the Your Information Page", YOUR_INFORMATION_TITLE);
        return driver.findElement(YOUR_INFORMATION_TITLE).getText();
    }

    @Override
    @Step("Открыта страница Your Information")
    public CheckoutYourInformationPage isPageOpened() {
        log.info("Waiting for the title '{}' to appear on the Your Information page", YOUR_INFORMATION_TITLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(YOUR_INFORMATION_TITLE));
        return this;
    }

    @Step("Заполнение данных с именем '{firstName}' фамилией '{lastName}' и почтовым кодом '{zipCode}' на странице CheckoutYourInformationPage'")
    public CheckoutOverviewPage fillOutAllFieldsAndContinue(String firstName, String lastName, String zipCode) {
        log.info("fill Out All Fields '{}', '{}', '{}' And click Continue  on the Checkout Overview page", firstName, lastName, zipCode);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }
}
