package com.sparta.room1.pages;

import net.serenitybdd.core.annotations.findby.How;
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

    @FindBy(xpath = "//a[@href='/login']")
    private WebElementFacade signUpLoginButton;

    public void clickSignUpLoginButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement loginLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/login']"))
        );
        loginLink.click();
    }
}