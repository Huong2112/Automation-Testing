package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Virtual Cards\n" +
            "Tab 2 of 3\"]")
    private WebElement virtualCard;


    @FindBy(xpath = "//android.view.View[@content-desc=\"Deposits\"]")
    private WebElement depositsTab;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Withdrawals\"]")
    private WebElement withdrawTab;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,\"USD\")]")
    private WebElement usDollarText;

    @FindBy(xpath = "//android.view.View[@content-desc=\"phpWallet\"]/preceding-sibling::android.widget.Button")
    private WebElement menuLeftIcon;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Request\"]")
    private WebElement request;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Settings\"]")
    private WebElement setting;

    public void clickToVirtualCard(){
        wait.until(ExpectedConditions.visibilityOf(virtualCard)).click();
    }

    private String getAmountFromTotal(){
        String totalText = wait.until(ExpectedConditions.visibilityOf(usDollarText)).getAttribute("content-desc");
        String[] strings = totalText.split("\n");
        String actualAmount = "";
        for (int i = 0; i < strings.length; i++){
            if (strings[i].equals("Amount")){
                String[] text = (strings[i+1]).split(" ");
                actualAmount += text[0];
                break;
            }
        }
        return actualAmount;

    }

    public boolean verifyUsDollarAmount(String expected){
        return getAmountFromTotal().equals(expected);
    }


    public void clickToMenuLeftIcon(){
        wait.until(ExpectedConditions.visibilityOf(menuLeftIcon)).click();
    }

    public void clickToRequest(){
        wait.until(ExpectedConditions.visibilityOf(request)).click();
    }

    public void clickToSetting(){
        ScrollUtils scrollUtils = new ScrollUtils();
        scrollUtils.swipeMobileUp(driver);
        wait.until(ExpectedConditions.visibilityOf(setting)).click();
    }

    public boolean verifyDepositAndWithdraw(){
        return wait.until(ExpectedConditions.visibilityOf(depositsTab)).isDisplayed()
                && withdrawTab.isDisplayed();
    }

}
