package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/product_details/1")
public class ProductDetailsPage extends PageObject {

    @FindBy(name = "quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "btn btn-default cart")
    private WebElementFacade addToCart;

//    @FindBy(className = "btn btn-default cart")
//    private WebElementFacade addToCart;




    //btn btn-default cart

}
