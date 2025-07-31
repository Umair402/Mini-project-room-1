package com.sparta.room1.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElementFacade emailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElementFacade loggedInAsMessage;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElementFacade errorMessage;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElementFacade nameField;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElementFacade emailSignUpField;

    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    private WebElementFacade newUserSignup;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElementFacade signupButton;

    public void enterUsername(String username) {
        emailField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ✅ Check for successful login message
    public boolean isLoginSuccessful() {
        return loggedInAsMessage.isDisplayed();
    }

    public String getLoggedInMessageText() {
        return loggedInAsMessage.getText();
    }

    // ✅ Check for login failure
    public boolean isLoginErrorDisplayed() {
        return errorMessage.isVisible();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    // ✅ Optionally expose the current URL
    public String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }

    public boolean isNewUserSignupVisible()
    {
        return newUserSignup.isVisible();
    }

    public void enterName(String name)
    {
        nameField.type(name);
    }

    public void entersignupEmail(String email)
    {
        emailSignUpField.type(email);
    }

    public void clickSignup()
    {
        signupButton.click();
    }

    public void signUpAs(String name, String email)
    {
        enterName(name);
        entersignupEmail(email);
        clickSignup();
    }

}
