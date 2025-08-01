package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("https://automationexercise.com/payment")
public class PaymentPage extends PageObject {

    @FindBy(css = ".form-control")
    List<WebElementFacade> paymentFields;

    @FindBy(xpath = "/html/body/section/div/div[3]/div/div[2]/form/div[5]/div/button")
    WebElementFacade payButton;

    public void enterCardName(String name){
        paymentFields.get(0).sendKeys(name);
    }

    public void enterCardNumber(String number){
        paymentFields.get(1).sendKeys(number);
    }

    public void enterCVCNumber(String number){
        paymentFields.get(2).sendKeys(number);
    }

    public void enterExpiryDate(String month, String year){
        paymentFields.get(3).sendKeys(month);
        paymentFields.get(4).sendKeys(year);
    }

    public void pay(){
        payButton.click();
    }

    public void scrollToItem(){
        Actions action = new Actions(getDriver());
        action.scrollByAmount(0,200).perform();
    }
}
