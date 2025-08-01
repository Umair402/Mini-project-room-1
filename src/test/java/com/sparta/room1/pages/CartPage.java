package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/view_cart")
public class CartPage extends PageObject {

    @FindBy(className = "disabled")
    private WebElementFacade cartQuantity;

    @FindBy(id = "empty_cart")
    private WebElementFacade emptyCartBlock;

    @FindBy(xpath = "/html/body/section/div/section/div[1]/div/div/a")
    private WebElementFacade proceedToCheckoutButton;


    public String getCartQuantity() {
        waitFor(cartQuantity).waitUntilVisible().waitUntilEnabled();
        return cartQuantity.getText();
    }

    public String getCartEmptyText() {
        waitFor(emptyCartBlock).waitUntilVisible().waitUntilEnabled();
        return emptyCartBlock.getTextContent();
    }

    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }

}
