package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            priority = 1,
            testName = "Проверка логина с позитивным именем пользователя и  паролем",
            description = "Проверка логина с позитивным именем пользователя и  паролем",
            invocationCount = 3,
            groups = {"smoke", "regression"}
    )
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "SO bad");

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test = title]")).getText();
        assertEquals(title, "Products");
    }

    @DataProvider(name = "Параметризованный тест для негативного логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Параметризованный тест для негативного логина",
            description = "Параметризованный тест для негативного логина",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
    public void chekLoginWithNegativeCred1(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage, "SO bad");
    }
}