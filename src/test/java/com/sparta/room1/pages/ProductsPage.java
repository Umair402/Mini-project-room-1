package com.sparta.room1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import javax.swing.*;
import java.util.List;


@DefaultUrl("https://automationexercise.com/")
public class ProductsPage extends PageObject {

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a")
    private WebElementFacade addToCartButtonOverlay;


    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
    private WebElementFacade addToCartButtonActual;

    @FindBy(css = ".choice")
    private List<WebElementFacade> productDetailsButtons;

    @FindBy(css = ".shop-menu ul li a")
    private List<WebElementFacade> shopMenuButtons;

    @FindBy(className = "cart")
    private WebElementFacade ProductDetailsCartButton;

    @FindBy(tagName = "u")
    private WebElementFacade goToCartAfterAddingButton;

    @FindBy(id = "quantity")
    private WebElementFacade quantityInput;

    @FindBy(className = "fc-cta-consent")
    private WebElementFacade consentButton;

    public void addToCartFromProductPage(int index){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(addToCartButtonActual).perform();
        addToCartButtonOverlay.click();
    }

    public void goToProductDetailsPage(int index){
        productDetailsButtons.get(index).click();
    }

    public void pressCartButton(){
        shopMenuButtons.get(3).click();
    }

    public void enterQuantityValue(String quantity){
        quantityInput.type(quantity);
    }

    public void goToCartAfterAddingItem(){
        goToCartAfterAddingButton.click();
    }

    public void clickConsent() {
        waitFor(consentButton).waitUntilClickable();
        consentButton.click();
    }

    public void scrollToItem(){
        Actions action = new Actions(getDriver());
        action.scrollByAmount(0,600).perform();
    }




}
