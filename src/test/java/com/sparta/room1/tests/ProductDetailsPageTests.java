package com.sparta.room1.tests;

import com.sparta.room1.pages.CartPage;
import com.sparta.room1.pages.ProductDetailsPage;
import com.sparta.room1.pages.ProductsPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProductDetailsPageTests {

    @Managed
    ProductsPage productsPage;

    @Managed
    ProductDetailsPage productDetailsPage;

    @Managed
    CartPage cartPage;


    @Managed
    WebDriver webDriver;

    @Test
    @DisplayName("""
              Given I am on the products page
              When I click "View Product" for any product on the product page
              And I set the product quantity to 4
              And I click the "Add to cart" button
              And I click the "View Cart" button
              Then I should see the product in the cart with quantity 4""")
    public void checkCartQuantity() {

        productsPage.open();
        productsPage.clickConsent();
        productsPage.goToProductDetailsPage(0);
        productDetailsPage.setQuantityTo4();
        productDetailsPage.addToCart();
        productDetailsPage.viewCart();
        assertThat(cartPage.getCartQuantity(), containsString("4"));


    }
}
