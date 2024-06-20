package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartScreen extends AppiumBase {
    public CartScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/tvProductName")
    private WebElement productName;

    @FindBy(id = "wrteam.multivendor.customer:id/tvPrice")
    private WebElement productPrice;

    @FindBy(id = "wrteam.multivendor.customer:id/tvMeasurement")
    private WebElement productMeasurement;

    @FindBy(id = "wrteam.multivendor.customer:id/tvTotalPrice")
    private WebElement productTotalPrice;

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"wrteam.multivendor.customer:id/lytMain\"]/descendant::android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvQuantity\"]")
    private WebElement quantity;

    @FindBy(id = "wrteam.multivendor.customer:id/tvDelete")
    private WebElement deleteButton;

    @FindBy(id = "wrteam.multivendor.customer:id/tvAction")
    private WebElement saveForLater;

    @FindBy(id = "wrteam.multivendor.customer:id/tvPromoCode")
    private WebElement promoCode;

    @FindBy(id = "wrteam.multivendor.customer:id/tvConfirmOrder")
    private WebElement continueButton;

    private boolean verifyProductName(String expName){
        return wait.until(ExpectedConditions.visibilityOf(productName)).isDisplayed()
                && productName.getAttribute("text").equals(expName);
    }

    private boolean verifyProductPrice(String expPrice){
        Assert.assertEquals(productPrice.getAttribute("text"), expPrice);
        return wait.until(ExpectedConditions.visibilityOf(productPrice)).isDisplayed()
                && productPrice.getAttribute("text").equals(expPrice);
    }

    private boolean verifyProductMeasurement(String expMeasurement){

        return wait.until(ExpectedConditions.visibilityOf(productMeasurement)).isDisplayed()
                && productMeasurement.getAttribute("text").equalsIgnoreCase(expMeasurement);
    }

    private boolean verifyProductTotalPrice(String expTotalPrice){
        return wait.until(ExpectedConditions.visibilityOf(productTotalPrice)).isDisplayed()
                && productTotalPrice.getAttribute("text").equals(expTotalPrice);
    }

    private boolean verifyProductQuantity(String expQuantity){
        return wait.until(ExpectedConditions.visibilityOf(quantity)).isDisplayed()
                && quantity.getAttribute("text").equals(expQuantity);
    }

    public boolean verifyCartScreen(String eName, String ePrice, String eMeasurement, String totalPrice, String quantity){
        return verifyProductName(eName) && verifyProductPrice(ePrice) && verifyProductMeasurement(eMeasurement)
                && verifyProductTotalPrice(totalPrice) && verifyProductQuantity(quantity)
                && deleteButton.isDisplayed()
                && saveForLater.isDisplayed()
                && promoCode.isDisplayed()
                && continueButton.isDisplayed();
    }

    public void clickToDeleteButton(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
    }

    public void clickToContinueButton(){
        wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
    }





}
