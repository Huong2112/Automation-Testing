package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VirtualCardPage extends AppiumBase {
    public VirtualCardPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Buy card\"]")
    private WebElement buyCardText;

    public void clickToBuyCard(){
        wait.until(ExpectedConditions.visibilityOf(buyCardText)).click();
    }
}
