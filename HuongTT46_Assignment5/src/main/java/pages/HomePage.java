package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "vn.tiki.app.tikiandroid:id/navCategories")
    private WebElement category;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement deny;

    public void clickToCategory(){
        wait.until(ExpectedConditions.visibilityOf(category)).click();
    }

    public void clickToDenyButton(){
        wait.until(ExpectedConditions.visibilityOf(deny)).click();
    }

}
