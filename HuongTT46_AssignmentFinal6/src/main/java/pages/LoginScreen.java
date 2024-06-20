package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginScreen extends AppiumBase {
    public LoginScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/btnLogin")
    private WebElement loginButton;

    @FindBy(id = "wrteam.multivendor.customer:id/edtLoginMobile")
    private WebElement mobileTextBox;

    @FindBy(id = "wrteam.multivendor.customer:id/imgLoginPassword")
    private WebElement passwordTextBox;

    @FindBy(id = "wrteam.multivendor.customer:id/tvForgotPass")
    private WebElement forgotPassword;

    @FindBy(id = "wrteam.multivendor.customer:id/tvSignUp")
    private WebElement signUpButton;



    public void clickToLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public boolean verifyLoginScreen(){
        return mobileTextBox.isDisplayed()
                && passwordTextBox.isDisplayed()
                && loginButton.isDisplayed()
                && forgotPassword.isDisplayed()
                && signUpButton.isDisplayed();
    }
}
