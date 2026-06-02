package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Login Page")
    public LoginPage open() {
        log.info("Opening Log In Page");
        driver.get(BASE_URL);
        return this;
    }

    @Override
    @Step("Открыта страница Login Page")
    public LoginPage isPageOpened() {
        log.info("Waiting for the title '{}' to appear on the Login Page", LOGIN_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Вход в систему с логином '{user}' и паролем '{password}'")
    public ProductsPage login(String user, String password) {
        log.info("fill Out positive cred user name '{}' and password '{}'  And click LOGIN BUTTON  on the login page", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Вход в систему с логином '{user}' и паролем '{password}'")
    public LoginPage loginWithNegativeCred(String user, String password) {
        log.info("fill Out negative cred user name '{}' and password '{}'  And click LOGIN BUTTON  on the login page", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        log.info("Getting for the Error Message '{}'  on the login page", ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
