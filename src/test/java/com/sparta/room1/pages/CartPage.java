package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/view_cart")
public class CartPage extends PageObject {

    @FindBy(className = "disabled")
    private WebElementFacade cartQuantity;


    public String getCartQuantity() {
        waitFor(cartQuantity).waitUntilVisible().waitUntilEnabled();
        return cartQuantity.getText();
    }




}
