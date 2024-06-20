package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AppiumBase {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/et_email")
    private WebElement email;

    @FindBy(id = "com.banggood.client:id/et_pwd")
    private WebElement password;

    @FindBy(id = "com.banggood.client:id/btn_sign_in")
    private WebElement signInButton;

    public boolean verifyLoginScreen(){
        return wait.until(ExpectedConditions.visibilityOf(email)).isDisplayed()
                && password.isDisplayed()
                && signInButton.isDisplayed();
    }

}
