package Laineros.PageObjects.tests;

import Laineros.PageObjects.pages.MainPage;
import Laineros.PageObjects.pages.components.ProductCard;
import Laineros.PageObjects.base.BaseTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.*;

@Epic("Shop")
@Feature("Products")
@Owner("Leo")
public class ProductTests extends BaseTest {

    @Test
    @Story("Products count")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that all four products are displayed")
    void shouldShowFourProducts() {
        MainPage page = new MainPage(driver);
        assertEquals(4, page.getProducts().size());
    }

    @Test
    @Story("MacBook price")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that MacBook price = 500")
    void macbookShouldCost500() {
        MainPage page = new MainPage(driver);
        ProductCard macbook = page.getProductByName("MacBook");

        assertTrue(macbook.getPrice().contains("500"));
    }

    @Test
    @Story("Check iPhone exist")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that product iPhone exist ant has correct title")
    void iphoneShouldExist() {
        MainPage page = new MainPage(driver);
        ProductCard iphone = page.getProductByName("iPhone");

        assertEquals("iPhone", iphone.getTitle());
    }

    @Test
    @Story("Add iPhone in cart")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check opportunity of adding iPhone in cart")
    void shouldAddIphoneToCart() {
        MainPage page = new MainPage(driver);
        ProductCard iphone = page.getProductByName("iPhone");

        iphone.clickBuy();
    }
}

