package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By Products = By.xpath("(//a[@href='/products'])[1]");
    By deleteItem = By.xpath("//tr[@id='product-1'] //a[@class='cart_quantity_delete']");
    By clickHereForBuyProduct = By.xpath("//u[normalize-space()='here']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItemFromCart() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(deleteItem).click();
    }

    public void clickToHereForBuyProducts() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(clickHereForBuyProduct).click();
    }


    private void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    // You can add cart validation methods here
}
