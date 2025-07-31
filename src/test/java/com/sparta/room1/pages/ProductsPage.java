package com.sparta.room1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://automationexercise.com/")
public class ProductsPage extends PageObject {

    @FindBy(css = "[data-product-id='1']")
    private WebElementFacade blueTopAddToCartButton;

    @FindBy(className = "cart")
    private WebElementFacade ProductDetailsCartButton;

    @FindBy(css = "[data-product-id='2']")
    private WebElementFacade menTshirtAddToCartButton;

    @FindBy(tagName = "u")
    private WebElementFacade goToCartButton;



}
