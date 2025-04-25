package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    By addProductIntoCart = By.xpath("//a[contains(@class, 'add-to-cart')]");
    By viewCart = By.xpath("//u[text()='View Cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(addProductIntoCart);
        WebElement firstButton = buttons.getFirst();

        Thread.sleep(2000);

        // Hover over the first product's parent or the button itself
        Actions actions = new Actions(driver);
        actions.moveToElement(firstButton).perform();

        Thread.sleep(1000); // Wait for any animation or hover effects
        actions.click(firstButton).perform();
        Thread.sleep(2000);
    }

    public void addSecondProductToCart() throws InterruptedException {

        scrollToElement(addProductIntoCart);
        List<WebElement> buttons = driver.findElements(addProductIntoCart);
        WebElement secondButton = buttons.get(1);

        Thread.sleep(2000);

        // Hover over the first product's parent or the button itself
        Actions actions = new Actions(driver);
        actions.moveToElement(secondButton).perform();

        Thread.sleep(1000); // Wait for any animation or hover effects
        actions.click(secondButton).perform();
        Thread.sleep(2000);
    }

    public void clickViewCart()
    {
        driver.findElement(viewCart).click();
    }

    private void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }


}
