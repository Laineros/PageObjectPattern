package Laineros.PageObjects.tests;

import Laineros.PageObjects.pages.MainPage;
import Laineros.PageObjects.pages.components.ProductCard;
import Laineros.PageObjects.base.BaseTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTests extends BaseTest {

    @Test
    void shouldShowFourProducts() {
        MainPage page = new MainPage(driver);
        assertEquals(4, page.getProducts().size());
    }

    @Test
    void macbookShouldCost500() {
        MainPage page = new MainPage(driver);
        ProductCard macbook = page.getProductByName("MacBook");

        assertTrue(macbook.getPrice().contains("500"));
    }

    @Test
    void iphoneShouldExist() {
        MainPage page = new MainPage(driver);
        ProductCard iphone = page.getProductByName("iPhone");

        assertEquals("iPhone", iphone.getTitle());
    }

    @Test
    void shouldAddIphoneToCart() {
        MainPage page = new MainPage(driver);
        ProductCard iphone = page.getProductByName("iPhone");

        iphone.clickBuy();
    }
}

