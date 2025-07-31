package com.sparta.room1.pages;

import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DefaultUrl("https://automationexercise.com/signup")
public class SignupPage  extends PageObject {

    @FindBy(how = How.XPATH, using = "//b[text()='Enter Account Information']")
    private WebElementFacade enterAccountInformation;

    @FindBy(id="id_gender1")
    private WebElementFacade MrRadio;

    @FindBy(id="id_gender2")
    private WebElementFacade MrsRadio;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(id="days")
    private WebElementFacade daysDropdown;

    @FindBy(id="months")
    private WebElementFacade monthsDropdown;

    @FindBy(id="years")
    private WebElementFacade yearsDropdown;

    @FindBy(id="newsletter")
    private WebElementFacade newsletterCheckbox;

    @FindBy(id="optin")
    private WebElementFacade optInCheckbox;

    @FindBy(id="first_name")
    private WebElementFacade firstNameField;

    @FindBy(id="last_name")
    private WebElementFacade lastNameField;

    @FindBy(id="address1")
    private WebElementFacade address1Field;

    @FindBy(id="address2")
    private WebElementFacade address2Field;

    @FindBy(id="country")
    private WebElementFacade countryDropdown;

    @FindBy(id="state")
    private WebElementFacade stateField;

    @FindBy(id="city")
    private WebElementFacade cityField;

    @FindBy(id="zipcode")
    private WebElementFacade ZipcodeField;

    @FindBy(id="mobile_number")
    private WebElementFacade mobilenumberField;

    @FindBy(xpath = "//input[@data-qa='create-account']")
    private WebElementFacade submitButton;

    public void clickMr() {MrRadio.click();}

    public void clickMrs() {MrsRadio.click();}

    public void enterPassword(String password) {passwordField.type(password);}

    public boolean enterAccountInformationIsVisible() {return enterAccountInformation.isVisible();}

    public void enterFirstName(String name) {firstNameField.type(name);}

    public void enterLastName(String name) {lastNameField.type(name);}

    public void enterAddress1(String address) {address1Field.type(address);}

    public void enterAddress2(String address) {address2Field.type(address);}

    public void enterState(String state) {stateField.type(state);}

    public void enterCity(String city) {cityField.type(city);}

    public void enterZipcode(String code){ZipcodeField.type(code);}

    public void enterMobileNumber(String number) {mobilenumberField.type(number);}

    public void enterDOB(String day, String month, String year)
    {
        SelectFromOptions.byValue(day).from(daysDropdown);
        SelectFromOptions.byValue(month).from(monthsDropdown);
        SelectFromOptions.byValue(year).from(yearsDropdown);
    }

    public void enterCountry(String country) {SelectFromOptions.byValue(country).from(countryDropdown);}


    public void clickCreateAccount()
    {
        submitButton.click();
    }



}
