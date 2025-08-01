package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl("https://automationexercise.com/signup")
public class SignupPage extends PageObject {

    @FindBy(how = How.XPATH, using = "//b[text()='Enter Account Information']")
    private WebElementFacade enterAccountInformation;

    @FindBy(id="id_gender1")
    private WebElementFacade mrRadio;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(id="days")
    private WebElementFacade dobDay;

    @FindBy(id="months")
    private WebElementFacade dobMonth;

    @FindBy(id="years")
    private WebElementFacade dobYear;

    @FindBy(id="newsletter")
    private WebElementFacade newsletterCheckbox;

    @FindBy(id="optin")
    private WebElementFacade receiveSpecialOffersCheckBox;

    @FindBy(id="first_name")
    private WebElementFacade firstName;

    @FindBy(id="last_name")
    private WebElementFacade lastName;

    @FindBy(id="company")
    private WebElementFacade company;

    @FindBy(id="address1")
    private WebElementFacade address1;

    @FindBy(id="address2")
    private WebElementFacade address2;

    @FindBy(id="country")
    private WebElementFacade country;

    @FindBy(id="state")
    private WebElementFacade stateField;

    @FindBy(id="city")
    private WebElementFacade cityField;

    @FindBy(id="zipcode")
    private WebElementFacade ZipcodeField;

    @FindBy(id="mobile_number")
    private WebElementFacade mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElementFacade createAccountButton;

    public boolean enterAccountInformationIsVisible() {
        return enterAccountInformation.isVisible();
    }

    public void clickMr() {
        mrRadio.click();
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void enterDOB(String day, String month, String year) {

        var selectDay = new Select(dobDay);
        selectDay.selectByVisibleText(day);

        var selectMonth = new Select(dobMonth);
        selectMonth.selectByVisibleText(month);

        var selectYear = new Select(dobYear);
        selectYear.selectByVisibleText(year);
    }

    public void selectSignupNewsletter() {
        newsletterCheckbox.click();
    }

    public void selectReceiveSpecialOffers() {
        receiveSpecialOffersCheckBox.click();
    }

    public void enterFirstName(String name) {
        firstName.type(name);
    }

    public void enterLastName(String name) {
        lastName.type(name);
    }

    public void enterCompany(String companyName) {
        company.type(companyName);
    }

    public void enterAddress1(String address) {
        address1.type(address);
    }

    public void enterAddress2(String address) {
        address2.type(address);
    }

    public void enterCountry(String countryText) {

        var selectDay = new Select(country);
        selectDay.selectByVisibleText(countryText);
    }

    public void enterState(String state) {
        stateField.type(state);
    }

    public void enterCity(String city) {
        cityField.type(city);
    }

    public void enterZipcode(String code){
        ZipcodeField.type(code);
    }

    public void enterMobileNumber(String number) {
        mobileNumberField.type(number);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
