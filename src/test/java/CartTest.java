import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test
    public void addBackpackToCart() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']")).click();
        String price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();
        String name = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
        softAssert.assertEquals(price, "$29.99");
        softAssert.assertEquals(name, "Sauce Labs Backpack");
        softAssert.assertAll();
    }
}
