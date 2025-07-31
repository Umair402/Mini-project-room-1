package com.sparta.room1.tests;

import com.sparta.room1.pages.ProductsPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class UserStory15_RegisterAndCheckout {
    @Managed
    private WebDriver webDriver;

    @Managed
    ProductsPage productsPage;


    @Test
    @DisplayName("When I register successfully, and add an item to cart I should be able to check out correctly")
    public void registerThenCheckout(){
        //Start up page
        //Sign up
        //Continue to products page
        productsPage.open();
        productsPage.clickConsent();
        productsPage.addToCartFromProductPage(1);
        productsPage.goToCartAfterAddingItem();


    }
}
