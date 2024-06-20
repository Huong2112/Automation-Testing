package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingPage extends AppiumBase {
    public SettingPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/ll_currency")
    private WebElement currency;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]//preceding-sibling::android.widget.ImageButton")
    private WebElement back;
    public void clickToCurrency(){
        wait.until(ExpectedConditions.visibilityOf(currency)).click();
    }

    public void clickToBack(){
        wait.until(ExpectedConditions.visibilityOf(back)).click();
    }
}
