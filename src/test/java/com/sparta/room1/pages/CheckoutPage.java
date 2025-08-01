package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://automationexercise.com/checkout")
public class CheckoutPage extends PageObject {

    @FindBy(xpath = "/html/body/section/div/div[7]/a")
    private WebElementFacade proceedToPaymentButton;


    public void proceedToCheckout(){
        proceedToPaymentButton.click();
    }

    public void scrollToItem(){
        Actions action = new Actions(getDriver());
        action.scrollByAmount(0,1000).perform();
    }
}
