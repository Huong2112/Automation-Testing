package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
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

    @FindBy(id = "com.banggood.client:id/main_tab_category")
    private WebElement category;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Hot Categories\"]")
    private WebElement hotCategory;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_title\" and @text=\"Smartphones\"]")
    private WebElement firstCategory;

    @FindBy(id = "com.banggood.client:id/main_tab_account")
    private WebElement account;

    @FindBy(id = "com.banggood.client:id/tab_view")
    private WebElement home;
    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement accessDeny;



    public void clickToCategory(){
        wait.until(ExpectedConditions.visibilityOf(category)).click();
    }

    public void scrollToHotCategories() throws InterruptedException {
        Thread.sleep(2000);
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.swipeMobileToCategory(driver);
        //swipeMobileUp();
    }

    public void clickToFirstCategory(){

        wait.until(ExpectedConditions.visibilityOf(firstCategory)).click();
    }

    public void clickToAccount(){
        wait.until(ExpectedConditions.visibilityOf(account)).click();
    }

    public void clickToHome(){
        wait.until(ExpectedConditions.visibilityOf(home)).click();
    }

    public void clickToDeny(){
        wait.until(ExpectedConditions.visibilityOf(accessDeny)).click();
    }





}
