package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return driver.findElement(YOUR_INFORMATION_TITLE).getText();
    }

    @Step("Заполнение данных с именем '{firstName}' фамилией '{lastName}' и почтовым кодом '{zipCode}' на странице CheckoutYourInformationPage'")
    public void fillOutAllFieldsAndContinue(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
