package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProfilePage extends AppiumBase {
    public EditProfilePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement currentPass;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
    private WebElement newPass;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
    private WebElement repeatNewPass;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"Submit\"])[2]")
    private WebElement submitButton;

    public void scrollIntoChangePassword(){
        ScrollUtils scrollUtils = new ScrollUtils();
        scrollUtils.swipeMobileUp(driver);
        scrollUtils.swipeMobileUp(driver);
    }

    public boolean verifyChangePasswordDisplay() {
        return wait.until(ExpectedConditions.visibilityOf(currentPass)).isDisplayed()
                && newPass.isDisplayed()
                && repeatNewPass.isDisplayed()
                && submitButton.isDisplayed();
    }

}
