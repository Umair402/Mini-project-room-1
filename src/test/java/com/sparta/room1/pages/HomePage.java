package com.sparta.room1.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://automationexercise.com")
public class HomePage extends PageObject {

    @FindBy(xpath = "//p[@class='fc-button-label' and text()='Consent']")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElementFacade signUpLoginButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElementFacade loggedInUser;

    @FindBy(xpath = "//a[@href='/delete_account' and contains(text(), 'Delete Account')]")
    private WebElementFacade deleteAccountLink;

    public void consentToUseData() {
        consentButton.click();
    }

    public void clickSignUpLoginButton() {
        signUpLoginButton.click();
    }

    public boolean loggedInAsUsernameIsVisible(String username) {
        loggedInUser.isVisible();
        return loggedInUser.containsText(username);
    }

    public void clickDeleteAccount() {
        deleteAccountLink.click();
    }
}