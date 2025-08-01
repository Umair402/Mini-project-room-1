package com.sparta.room1.tests;

import com.sparta.room1.pages.*;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class UserStory16LoginAndCheckout {
    @Managed
    private WebDriver webDriver;

    @Managed
    LoginPage loginPage;

    @Managed
    ProductsPage productsPage;

    @Managed
    CartPage cartPage;

    @Managed
    CheckoutPage checkoutPage;

    @Managed
    PaymentPage paymentPage;


    @Test
    @DisplayName("When I register successfully, and add an item to cart I should be able to check out correctly")
    public void registerThenCheckout(){
        loginPage.open();
        loginPage.clickConsent();
        loginPage.enterUsername("example@sparta2.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();
        String currentUrl = loginPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/"));
        productsPage.scrollToItem();
        productsPage.addToCartFromProductPage(1);
        productsPage.goToCartAfterAddingItem();
        currentUrl = productsPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/view_cart"));
        cartPage.proceedToCheckout();
        currentUrl = productsPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/checkout"));
        checkoutPage.scrollToItem();
        checkoutPage.proceedToCheckout();
        currentUrl = productsPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/payment"));
        paymentPage.enterCardName("ABCDEFG");
        paymentPage.enterCardNumber("12345566789");
        paymentPage.enterCVCNumber("311");
        paymentPage.enterExpiryDate("07", "2030");
        paymentPage.scrollToItem();
        paymentPage.pay();
        currentUrl = productsPage.getDriver().getCurrentUrl();
        assertThat(currentUrl, containsString("automationexercise.com/payment_done"));




    }
}
