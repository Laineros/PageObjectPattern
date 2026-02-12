package Laineros.PageObjects.pages;

import Laineros.PageObjects.pages.components.ProductCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    private By productCards = By.cssSelector(".product-layout");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getProducts() {
        List<WebElement> elements = driver.findElements(productCards);
        List<ProductCard> cards = new ArrayList<>();

        for (WebElement el : elements) {
            cards.add(new ProductCard(el));
        }
        return cards;
    }

    public ProductCard getProductByName(String name) {
        return getProducts()
                .stream()
                .filter(p -> p.getTitle().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + name));
    }
}

