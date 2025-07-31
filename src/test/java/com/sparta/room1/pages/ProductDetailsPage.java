package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("https://automationexercise.com/product_details")
public class ProductDetailsPage extends PageObject {

    @FindBy(id = "quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "btn-default")
    private WebElementFacade addToCart;

    @FindBy(tagName = "u")
    private WebElementFacade viewCart;


//    @FindBy(className = "btn btn-default cart")
//    private WebElementFacade ViewCart;

    public void setQuantityTo4(){
        cartQuantity.sendKeys(Keys.ARROW_UP);
        cartQuantity.sendKeys(Keys.ARROW_UP);
        cartQuantity.sendKeys(Keys.ARROW_UP);

    }

    public void addToCart() {
        addToCart.click();
    }

    public void viewCart() {
        viewCart.click();
    }



}
