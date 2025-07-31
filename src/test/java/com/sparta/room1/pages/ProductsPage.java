package com.sparta.room1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;


@DefaultUrl("https://automationexercise.com/products")
public class ProductsPage extends PageObject {

    @FindBy(css = ".add-to-cart")
    private List<WebElementFacade> AddToCartButtons;

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
        AddToCartButtons.get(index).click();
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


}
