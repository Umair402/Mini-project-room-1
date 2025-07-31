package com.sparta.room1.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    @FindBy(css = "input[data-qa='login-email']")
    private WebElementFacade emailField;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElementFacade passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(className = "fc-cta-consent")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//a[contains(text(),\"Logged in as\")]")
    private WebElementFacade loggedInAsMessage;

    @FindBy(xpath = "//p[contains(text(),\"Your email or password is incorrect!\")]")
    private WebElementFacade errorMessage;

    
    public void enterUsername(String username) {
        waitFor(emailField).waitUntilVisible().waitUntilEnabled();
        emailField.type(username);
    }

    public void enterPassword(String password) {
        waitFor(passwordField).waitUntilVisible().waitUntilEnabled();
        passwordField.type(password);
    }

    public void clickLogin() {
        waitFor(loginButton).waitUntilClickable();
        loginButton.click();
    }
    public void clickConsent() {
        waitFor(consentButton).waitUntilClickable();
        consentButton.click();
    }

    public void loginAs(String username, String password) {
        waitFor(emailField);
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginSuccessful() {
        return loggedInAsMessage.isDisplayed();
    }

    public String getLoggedInMessageText() {
        return loggedInAsMessage.getText();
    }

    public boolean isLoginErrorDisplayed() {
        return errorMessage.isVisible();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }
}
