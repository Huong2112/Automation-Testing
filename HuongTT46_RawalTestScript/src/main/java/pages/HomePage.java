package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Categories\n" +
            "Tab 2 of 4\"]")
    private WebElement category;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"My Account\n" +
            "Tab 4 of 4\"]")
    private WebElement myAccount;

    @FindBy(xpath = "//android.view.View[@content-desc=\"0\"]")
    private WebElement cartIcon;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")
    private WebElement searchBox;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Home\n" +
            "Tab 1 of 4\"]")
    private WebElement homeIcon;

    public void clickToCategory(){
        getWait().until(ExpectedConditions.visibilityOf(category)).click();
    }

    public void clickToMyAccount(){
        getWait().until(ExpectedConditions.visibilityOf(myAccount)).click();
    }

    public void clickToCartIcon(){
        getWait().until(ExpectedConditions.visibilityOf(cartIcon)).click();
    }

    public void clickToSearchBox(){
        getWait().until(ExpectedConditions.visibilityOf(searchBox)).click();
    }

    public void clickToHomeIcon(){
        getWait().until(ExpectedConditions.visibilityOf(homeIcon)).click();
    }




}
