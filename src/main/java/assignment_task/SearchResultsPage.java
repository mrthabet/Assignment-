package assignment_task;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    WebDriver driver;

    // Constructor
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By productPrices = By.cssSelector(".a-price .a-price-whole");
    By productLinks = By.cssSelector(".s-title-instructions-style");

    // Methods
    public String getProductPrice(int index) {
        java.util.List<WebElement> prices = driver.findElements(productPrices);
        return prices.get(index).getText();
    }

    public void selectProduct(int index) {
        java.util.List<WebElement> productList = driver.findElements(productLinks);
        productList.get(index).click();
    }
}
