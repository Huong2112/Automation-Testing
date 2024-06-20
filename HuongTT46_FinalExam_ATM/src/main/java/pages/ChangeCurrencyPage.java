package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeCurrencyPage extends AppiumBase {
    public ChangeCurrencyPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_currency_name\" and @text=\"USD\"]")
    private WebElement usd;

    public void clickToUSD(){
        wait.until(ExpectedConditions.visibilityOf(usd)).click();
    }


}
