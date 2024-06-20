package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.PublicKey;

public class ProfileScreen extends AppiumBase {
    public ProfileScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(id = "wrteam.multivendor.customer:id/tvName")
    private WebElement welcomeGuest;

    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuHome")
    private WebElement home;
    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuCart")
    private WebElement cart;

    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuNotification")
    private WebElement notifications;
    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuOrders")
    private WebElement yourOrders;
    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuWalletHistory")
    private WebElement walletHistory;
    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuTransactionHistory")
    private WebElement transactionHistory;
    @FindBy(id = "wrteam.multivendor.customer:id/tvMenuChangePassword")
    private WebElement changePassword;


    public void clickToWelcomeGuest(){
        wait.until(ExpectedConditions.visibilityOf(welcomeGuest)).click();
    }

    public boolean verifyProfileScreen(){
        wait.until(ExpectedConditions.visibilityOf(home));
        return home.isDisplayed()
                && cart.isDisplayed()
                && notifications.isDisplayed()
                && yourOrders.isDisplayed()
                && walletHistory.isDisplayed()
                && transactionHistory.isDisplayed()
                && changePassword.isDisplayed();
    }
}
