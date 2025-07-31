package com.sparta.room1.tests;

import com.sparta.room1.pages.LoginPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTests {

    @Managed
    LoginPage loginPage;

    @Managed
    private WebDriver webDriver;

    @Test
    @DisplayName("""
      Given I enter a valid username and password,
      When I click login,
      Then I should land on the inventory page""")
    public void loginTest() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("example@sparta2.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();
        String currentUrl = loginPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/"));
    }

    @Test
    @DisplayName("""
      Given I enter an invalid password,
      When I click login,
      Then I should see an error message saying the credentials are incorrect""")
    public void loginFailsWithWrongPassword() {
        loginPage.open();
        loginPage.clickConsent(); // optional, if cookie popup appears
        loginPage.enterUsername("example@sparta2.com");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickLogin();

        assertThat("Error message should be displayed", loginPage.isLoginErrorDisplayed());
        assertThat(loginPage.getErrorMessageText(), containsString("Your email or password is incorrect!"));
    }

    @Test
    @DisplayName("""
      Given I enter an invalid email,
      When I click login,
      Then I should see an error message saying the credentials are incorrect""")
    public void loginFailsWithWrongEmail() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("invalid@email.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();

        assertThat("Error message should be displayed", loginPage.isLoginErrorDisplayed());
        assertThat(loginPage.getErrorMessageText(), containsString("Your email or password is incorrect!"));
        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }

    @Test
    @DisplayName("""
      Given I leave the email field empty,
      When I enter a valid password and click login,
      Then I should see an error or remain on the login page""")
    public void loginFailsWithEmptyEmail() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();

        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }
    @Test
    @DisplayName("""
      Given I leave the password field empty,
      When I enter a valid email and click login,
      Then I should see an error or remain on the login page""")
    public void loginFailsWithEmptyPassword() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("example@sparta2.com");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }

    @Test
    @DisplayName("""
      Given I leave both fields empty,
      When I click login,
      Then I should see an error or remain on the login page""")
    public void loginFailsWithEmptyForm() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }

    @Test
    @DisplayName("""
      Given I enter a malformed email address,
      When I enter a valid password and click login,
      Then I should see a validation error or remain on login page""")
    public void loginFailsWithMalformedEmail() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("invalid-email");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();

        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }

    @Test
    @DisplayName("""
      Given I enter special characters in both fields,
      When I click login,
      Then I should see an error or remain on the login page""")
    public void loginFailsWithSpecialCharacters() {
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("!@#$%^&*()");
        loginPage.enterPassword("()_+{}|\":?><");
        loginPage.clickLogin();

        assertThat("Should remain on login page", loginPage.getDriver().getCurrentUrl(), containsString("/login"));
    }


}
