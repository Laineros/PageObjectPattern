package Laineros.PageObjects.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCard {

    private WebElement root;

    public ProductCard(WebElement root) {
        this.root = root;
    }

    private By title = By.cssSelector("h4 a");
    private By description = By.cssSelector(".caption p");
    private By price = By.cssSelector(".price");
    private By buyButton = By.cssSelector(".button-group button:nth-child(1)");
    private By wishlistButton = By.cssSelector(".button-group button:nth-child(2)");
    private By compareButton = By.cssSelector(".button-group button:nth-child(3)");

    public String getTitle() {
        return root.findElement(title).getText();
    }

    public String getDescription() {
        return root.findElement(description).getText();
    }

    public String getPrice() {
        return root.findElement(price).getText();
    }

    public void clickBuy() {
        root.findElement(buyButton).click();
    }

    public void addToWishlist() {
        root.findElement(wishlistButton).click();
    }

    public void addToCompare() {
        root.findElement(compareButton).click();
    }
}
