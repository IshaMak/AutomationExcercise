package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By expandWomen = By.xpath("//div[@id='accordian'] //a[@href='#Women']");
    By expandMen = By.xpath("//div[@id='accordian'] //a[@href='#Men']");
    By expandKids = By.xpath("//div[@id='accordian'] //a[@href='#Kids']");

    By topsSubCategory = By.xpath("//div[@id='Women'] //a[contains(text(),'Tops')]");
    By sareeSubCategory = By.xpath("//div[@id='Women'] //a[contains(text(),'Saree')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectWomenTops() throws InterruptedException {
        scrollToElement(expandWomen);
        driver.findElement(expandWomen).click();
        driver.findElement(topsSubCategory).click();
        Thread.sleep(2000);
    }

    public void selectWomenSaree() throws InterruptedException {
        scrollToElement(expandWomen);
        driver.findElement(expandWomen).click();
        driver.findElement(sareeSubCategory).click();
        Thread.sleep(2000);
    }

    private void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }


}
