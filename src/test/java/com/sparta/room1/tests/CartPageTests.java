package com.sparta.room1.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartPageTests {

    @Test
    @DisplayName("""
              Given I am on the products page
              When I click "View Product" for any product on the product page
              And I set the product quantity to 4
              And I click the "Add to cart" button
              And I click the "View Cart" button
              Then I should see the product in the cart with quantity 4""")
    public void checkCartQuantity() {



    }
}
