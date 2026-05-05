import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.tagName("footer"));
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Light"));
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[contains(@data-test,'-copy')]"));
        driver.findElement(By.xpath("//div[contains(text(),'T-Shirt (Red)')]"));
        driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::img"));
        driver.findElement(By.xpath(("//div[text()='49.99']/following::button[1]")));
        driver.findElement(By.xpath("//div/parent::a"));
        driver.findElement(By.xpath("//div[@class='pricebar']/preceding::*"));
        driver.findElement(By.xpath("//div[@class='inventory_item_name ' and @data-test='inventory-item-name']"));
        driver.findElement(By.cssSelector(".inventory_item_price"));
        //- .class1.class2 - какой из элементов на странице имеет одновременно 2 класса?
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("div.inventory_item_price"));
        driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-fleece-jacket]"));
        driver.findElement(By.cssSelector("[class~=btn]"));
        driver.findElement(By.cssSelector("[class^=btn]"));
        driver.findElement(By.cssSelector("[data-test*=social]"));
    }
}
