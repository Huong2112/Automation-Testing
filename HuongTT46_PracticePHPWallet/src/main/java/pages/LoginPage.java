package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends AppiumBase {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement email;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement password;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    private WebElement loginButton;


    public void input(String emailInput, String passInput) throws InterruptedException {

        WebElement e = wait.until(ExpectedConditions.visibilityOf(email));
        e.click();
        e.sendKeys(emailInput);
        ScrollUtils scrollUtils = new ScrollUtils();
        scrollUtils.swipeMobileUp1(driver);


        WebElement p = wait.until(ExpectedConditions.visibilityOf(password));
        p.click();
       p.sendKeys(passInput);

        Thread.sleep(500);
    }

    public void clickToLoginButton() throws InterruptedException {
        Thread.sleep(500);
        loginButton.click();
    }
}
