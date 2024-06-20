package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BeverageListScreen extends AppiumBase {
    public BeverageListScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Search\"]")
    private WebElement searchIcon;

    public void clickToSearchIcon(){
        wait.until(ExpectedConditions.visibilityOf(searchIcon)).click();
    }
}
