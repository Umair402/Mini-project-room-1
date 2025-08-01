package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.List;

@DefaultUrl("https://automationexercise.com/product_details")
public class ProductDetailsPage extends PageObject {

    @FindBy(id = "quantity")
    private WebElementFacade cartQuantity;

    @FindBy(className = "btn-default")
    private WebElementFacade addToCart;

    @FindBy(tagName = "u")
    private WebElementFacade viewCart;

    @FindBy(css = "a[href*='/view_cart']")
    private WebElementFacade navCart;



    public void setQuantityTo4(){
        cartQuantity.sendKeys(Keys.ARROW_UP);
        cartQuantity.sendKeys(Keys.ARROW_UP);
        cartQuantity.sendKeys(Keys.ARROW_UP);

    }

    public void setQuantityToAlphaNumeric(){

        String alphaNumericText = "abc";
        StringSelection stringSelection = new StringSelection(alphaNumericText);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        cartQuantity.click();
        cartQuantity.sendKeys(Keys.chord(Keys.CONTROL, "v"));

    }

    public void addToCart() {
        addToCart.click();
    }

    public void viewCart() {
        viewCart.click();
    }

    public void viewNavCart() {
        navCart.click();
    }



}
