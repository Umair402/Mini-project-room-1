package com.sparta.room1.tests;

import com.sparta.room1.pages.HomePage;
import com.sparta.room1.pages.LoginPage;
import com.sparta.room1.pages.SignupPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

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

    @Test
    @DisplayName("")
    public void registerUserTest() {

        // Arrange
        homePage.open();
        assertThat(webDriver.getCurrentUrl(), is(HOME_PAGE_URL));

        homePage.clickSignUpLoginButton();
        loginPage.isNewUserSignupVisible();

        // Act
        loginPage.signUpAs("New User", "User" + Math.random() + "@sparta.com");

        assertTrue(signupPage.enterAccountInformationIsVisible());

        signupPage.clickMr();
        signupPage.enterPassword("password12345");
        signupPage.enterFirstName("Joe");
        signupPage.enterLastName("Blogs");
        signupPage.enterAddress1("Test Address, 123 Lane");
        signupPage.enterState("Despair");
        signupPage.enterCity("of Gold");
        signupPage.enterZipcode("BB7 BB7");
        signupPage.enterMobileNumber("12345678910");
        signupPage.enterDOB("1", "1", "2000");
        signupPage.enterCountry("India");
        signupPage.clickCreateAccount();
    }
}