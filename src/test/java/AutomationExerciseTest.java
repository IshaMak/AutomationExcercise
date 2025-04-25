import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class AutomationExerciseTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void cart_AddProduct_RemoveProduct_AddSameProductAgain() throws InterruptedException {
        // Step 1-2: Go to Women > Tops
        homePage.selectWomenTops();

        // Step 3: Add first product
        productPage.addFirstProductToCart();

        // Step 4: View Cart
        productPage.clickViewCart();

        // Step 5: remove item from cart
        cartPage.removeItemFromCart();

        // Step 6: click here to buy product
        cartPage.clickToHereForBuyProducts();

        // Step 7: Again select deleted product
        homePage.selectWomenTops();

        // Step 8: Add product in cart
        productPage.addFirstProductToCart();

        // Step 9: View Cart
        productPage.clickViewCart();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
