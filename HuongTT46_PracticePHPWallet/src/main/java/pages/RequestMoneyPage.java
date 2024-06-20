package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RequestMoneyPage extends AppiumBase {
    public RequestMoneyPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(xpath = "//android.view.View[@content-desc=\"USD\"]/following-sibling::android.widget.EditText")
    private WebElement amount;

    @FindBy(xpath = "(//android.view.View[@content-desc=\"USD\"]/following-sibling::android.widget.EditText)[2]")
    private WebElement email;

    @FindBy(xpath = "(//android.view.View[@content-desc=\"USD\"]/following-sibling::android.widget.EditText)[3]")
    private WebElement description;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Send MoneyRequest\"]")
    private WebElement sendButton;

    public boolean verifyRequestMoneyScreen(){
        return wait.until(ExpectedConditions.visibilityOf(amount)).isDisplayed()
                && email.isDisplayed()
                && description.isDisplayed()
                && sendButton.isDisplayed();
    }


}
