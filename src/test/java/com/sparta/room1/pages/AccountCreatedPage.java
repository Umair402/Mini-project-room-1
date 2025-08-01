package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/account_created")
public class AccountCreatedPage extends PageObject {

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElementFacade accountCreatedHeader;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElementFacade continueButton;

    public boolean accountCreatedIsVisible() {
        return accountCreatedHeader.isVisible();
    }

    public void clickContinue() {
        continueButton.click();
    }
}
