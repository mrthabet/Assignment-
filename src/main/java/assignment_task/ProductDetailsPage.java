package assignment_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By priceOnProductPage = By.id("priceblock_ourprice");
    By addToCartButton = By.id("add-to-cart-button");

    // Methods
    public String getProductPriceOnDetailsPage1() {
        return driver.findElement(priceOnProductPage).getText();
    }

    public void addToCart1() {
        driver.findElement(addToCartButton).click();
    }

	public void addToCart() {
		// TODO Auto-generated method stub
		
	}

	public String getProductPriceOnDetailsPage() {
		// TODO Auto-generated method stub
		return null;
	}
}
