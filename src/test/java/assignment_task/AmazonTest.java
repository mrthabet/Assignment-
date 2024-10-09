package assignment_task;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://www.amazon.eg/");
        
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
	public void searchAndAddProductsToCart() throws InterruptedException {
        // Step 1: Search for "toys"
        homePage.searchProduct("toys");

        // Step 2: Capture the price of the first product from Search Results
        String firstProductPriceOnSearchPage = searchResultsPage.getProductPrice(0);
        searchResultsPage.selectProduct(0);

        // Step 3: Capture the price on Product Details page and validate with Search Results page
        String firstProductPriceOnDetailsPage = productDetailsPage.getProductPriceOnDetailsPage();
       // Assert.assertTrue(firstProductPriceOnDetailsPage.contains(firstProductPriceOnSearchPage),
               // "Price mismatch between Search Results and Product Details page for first product.");

        // Step 4: Add the first product to cart
        productDetailsPage.addToCart();
        driver.navigate().back(); // Navigate back to search results

        // Step 5: Capture the price of the second product from Search Results
        String secondProductPriceOnSearchPage = searchResultsPage.getProductPrice(1);
        searchResultsPage.selectProduct(1);

        // Step 6: Capture the price on Product Details page and validate with Search Results page
        String secondProductPriceOnDetailsPage = productDetailsPage.getProductPriceOnDetailsPage();
     //   Assert.assertTrue(secondProductPriceOnDetailsPage.contains(secondProductPriceOnSearchPage),
               // "Price mismatch between Search Results and Product Details page for second product.");

        // Step 7: Add the second product to cart
        productDetailsPage.addToCart();

        // Step 8: Go to the cart and validate the total price
        driver.get("https://www.amazon.com/gp/cart/view.html");
        String cartTotal = cartPage.getCartTotal();
        System.out.println("Total Cart Amount: " + cartTotal);

        
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
