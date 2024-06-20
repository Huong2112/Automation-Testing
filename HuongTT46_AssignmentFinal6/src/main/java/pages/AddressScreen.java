package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressScreen extends AppiumBase {
    public AddressScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvDefaultAddress\"]/../../..")
    private WebElement defaultAddress;

    @FindBy(id = "wrteam.multivendor.customer:id/tvConfirmOrder")
    private WebElement continueButton;

    public void clickToDefaultAddress(){
        wait.until(ExpectedConditions.visibilityOf(defaultAddress)).click();
    }

    public void clickToContinueButton(){
        wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
    }


}
