package assignment_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartSubtotal = By.id("sc-subtotal-amount-activecart");

    // Methods
    public String getCartTotal() {
        return driver.findElement(cartSubtotal).getText();
    }
}
