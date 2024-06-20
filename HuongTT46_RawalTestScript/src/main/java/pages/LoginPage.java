package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter your email\"]")
    private WebElement email;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter your password\"]")
    private WebElement password;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Sign In\"]")
    private WebElement signInButton;

    private WebElement firstName;
    private WebElement lastName;
    private WebElement emailSignUp;
    private WebElement passwordSignup;
    private WebElement confirmPassword;
    private WebElement signUpButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Sign In\n" +
            "Tab 1 of 2\"]")
    private WebElement signInTab;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Sign Up\n" +
            "Tab 2 of 2\"]")
    private WebElement signUpTab;


    private boolean verifySignIn(){
        return getWait().until(ExpectedConditions.visibilityOf(email)).isDisplayed()
                && password.isDisplayed()
                && signInButton.isDisplayed();

    }
    private  boolean verifySignUp(){
        signUpTab.click();
        return getWait().until(ExpectedConditions.visibilityOf(firstName)).isDisplayed()
                && lastName.isDisplayed()
                && emailSignUp.isDisplayed()
                && passwordSignup.isDisplayed()
                && confirmPassword.isDisplayed();
    }

    public boolean verifyLoginPage(){
        return getWait().until(ExpectedConditions.visibilityOf(signInTab)).isDisplayed()
                && signUpTab.isDisplayed()
                && verifySignIn()
                && verifySignUp();
    }

    public void clickToSignUpTab(){
        getWait().until(ExpectedConditions.visibilityOf(signUpTab)).click();
    }

    public void signUp(String fname, String lname, String e, String p, String re_p){
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailSignUp.sendKeys(e);
        passwordSignup.sendKeys(p);
        confirmPassword.sendKeys(re_p);
        signUpButton.click();
    }


}
