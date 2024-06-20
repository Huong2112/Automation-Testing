package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends AppiumBase {
    public AccountPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/tv_view_all")
    private WebElement viewAllOrder;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_feature_name\" and @text=\"Settings\"]")
    private WebElement setting;


    public void clickToViewAllOrder(){
        wait.until(ExpectedConditions.visibilityOf(viewAllOrder)).click();
    }
    public void clickToSetting(){

        wait.until(ExpectedConditions.visibilityOf(setting)).click();
    }

    public void scrollToSetting(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.lightScrollInLeftMenu(driver);
    }

}
