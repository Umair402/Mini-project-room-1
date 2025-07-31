package com.sparta.room1.tests;

import com.sparta.room1.pages.LoginPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
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
    public void loginTest() {
        loginPage.open(); // only works if @DefaultUrl is defined in LoginPage
        loginPage.enterUsername("user@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

        String title = loginPage.getTitle();
        assertThat(title, containsString("Dashboard"));

        String currentUrl = loginPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("/dashboard"));


    }
}
