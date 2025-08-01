package com.sparta.room1.tests;

import com.sparta.room1.pages.ProductsPage;
import com.sparta.room1.pages.ProductDetailsPage;
import com.sparta.room1.pages.CartPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddToCardTest {

    @Managed
    ProductsPage productsPage;

    @Managed
    ProductDetailsPage productDetailsPage;

    @Managed
    CartPage cartPage;

    @Managed
    private WebDriver webDriver;

    @Test
    @DisplayName("""
      Given the user is on the home page
      When the user scrolls to the "Products" section
      And the user clicks on the "View Product" button for a product
      And the user clicks on "Add to cart"
      Then a confirmation modal should appear with the message "Product added"
      When the user clicks on "View Cart"
      Then the cart page should display the selected product
      And the product quantity should be 1 by default
      And the product price should match the product’s detail page""")
    public void addtocartTest(){
        productsPage.open();
        productsPage.clickConsent();
        productsPage.evaluateJavascript("window.scrollBy(0, 1000)");
        int productIndex = 1;
        productsPage.goToProductDetailsPage(productIndex);
        //productsPage.addToCartFromProductPage(productIndex);
        //productsPage.goToCartAfterAddingItem();
        //cartPage.getCartQuantity();




    }

}
