package testframework;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.checkerframework.framework.qual.DefaultQualifier;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@data-qa='login-email']")
    private WebElementFacade emailFieldLogin;

    @FindBy(xpath = "//*[@data-qa='password']")
    private WebElementFacade passordField;

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    private WebElementFacade nameField;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    private WebElementFacade emailFieldSignup;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    private WebElementFacade signupButton;



    public void enterEmailLogin(String email)
    {
        emailFieldLogin.type(email);
    }

    public void enterPasswordLogin(String password)
    {
        passordField.type(password);
    }

    public void enterNameSignup(String name)
    {
        nameField.type(name);
    }

    public void enterEmailSignup(String email)
    {
        emailFieldSignup.type(email);
    }




}
