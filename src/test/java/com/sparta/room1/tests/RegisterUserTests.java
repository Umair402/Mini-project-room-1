package com.sparta.room1.tests;

import com.sparta.room1.pages.*;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class RegisterUserTests {

    private static final String HOME_PAGE_URL = "https://automationexercise.com/";

    @Managed
    private WebDriver webDriver;

    @Managed
    HomePage homePage;

    @Managed
    LoginPage loginPage;

    @Managed
    SignupPage signupPage;

    @Managed
    AccountCreatedPage accountCreatedPage;

    @Managed
    DeleteAccountPage deleteAccountPage;

    @Test
    @DisplayName("")
    public void registerUserTest() {

        var name = "New User";

        // Arrange
        homePage.open();
        homePage.consentToUseData();
        assertThat(webDriver.getCurrentUrl(), is(HOME_PAGE_URL));

        // Act - sign up
        homePage.clickSignUpLoginButton();

        // Assert - "New User Signup!" is visible
        assertTrue(loginPage.isNewUserSignupVisible());


        // Arrange - enter new name and email
        loginPage.enterSignupName(name);
        loginPage.enterSignupEmail("user" + new Random().nextInt() + "@example.com");

        // Act
        loginPage.clickSignup();

        // Assert - "Enter account information" is visible
        assertTrue(signupPage.enterAccountInformationIsVisible());


        // Arrange - enter account information
        signupPage.clickMr();
        signupPage.enterPassword("password12345");
        signupPage.enterDOB("1", "January", "2000");
        signupPage.selectSignupNewsletter();
        signupPage.selectReceiveSpecialOffers();
        signupPage.enterFirstName("Joe");
        signupPage.enterLastName("Blogs");
        signupPage.enterCompany("Company");
        signupPage.enterAddress1("TestAddress1");
        signupPage.enterAddress2("TestAddress2");
        signupPage.enterState("Despair");
        signupPage.enterCity("of Gold");
        signupPage.enterZipcode("BB7 BB7");
        signupPage.enterMobileNumber("12345678910");
        signupPage.enterCountry("India");

        // Act
        signupPage.clickCreateAccount();

        // Assert - "Account created!" is visible
        assertTrue(accountCreatedPage.accountCreatedIsVisible());


        // Act
        accountCreatedPage.clickContinue();

        // Assert - Logged in as username is visible
        assertTrue(homePage.loggedInAsUsernameIsVisible(name));


        // Act
        homePage.clickDeleteAccount();

        // Assert - Account deleted is visible
        assertTrue(deleteAccountPage.accountDeletedMessageIsVisible());
    }
}