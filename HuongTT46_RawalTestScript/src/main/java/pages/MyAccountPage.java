package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {
    public MyAccountPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"In Progress\"]")
    private WebElement inProgress;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Delivered\"]")
    private WebElement delivered;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Reviews\"]")
    private WebElement reviews;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Address\"]")
    private WebElement address;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile\"]")
    private WebElement profiles;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Rewards\"]")
    private WebElement rewards;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Feedback\"]")
    private WebElement feedbacks;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Share\"]")
    private WebElement share;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Rate us\"]")
    private WebElement rateUs;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Welcome \n" +
            "Please Login\"]")
    private WebElement welcome;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, \"Welcome\")]")
    private WebElement afterSignUpWelcome;


    private boolean verifyMyOrdersDisplay(){
        return getWait().until(ExpectedConditions.visibilityOf(inProgress)).isDisplayed()
                && delivered.isDisplayed()
                && reviews.isDisplayed();
    }
    private boolean verifyHelpInforDisplay(){
        return getWait().until(ExpectedConditions.visibilityOf(address)).isDisplayed()
                && profiles.isDisplayed()
                && rewards.isDisplayed()
                && feedbacks.isDisplayed()
                && share.isDisplayed()
                && rateUs.isDisplayed();
    }

    public boolean verifyMyAccountDisplay(){
        return verifyMyOrdersDisplay() && verifyHelpInforDisplay();
    }
    public void clickToWelcome(){
        getWait().until(ExpectedConditions.visibilityOf(welcome)).click();
    }

    public boolean verifyWelcome(String exp){
        return afterSignUpWelcome.getText().equals(exp);
    }




}
