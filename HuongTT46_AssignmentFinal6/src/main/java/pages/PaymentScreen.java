package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PaymentScreen extends AppiumBase {
    public PaymentScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(id = "wrteam.multivendor.customer:id/tvShippingDetailTitle")
    private WebElement shippingDetail;

    @FindBy(id = "wrteam.multivendor.customer:id/tvAddress")
    private WebElement addressText;


    @FindBy(id = "wrteam.multivendor.customer:id/tvSelectDeliveryDate")
    private WebElement deliveryDateTime;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Grand Total\"]")
    private WebElement grandTotalText;

    @FindBy(id = "wrteam.multivendor.customer:id/tvGrandTotal")
    private WebElement grandTotalValue;

    @FindBy(id = "wrteam.multivendor.customer:id/tvOrderSummary")
    private WebElement orderSummary;

    @FindBy(id = "wrteam.multivendor.customer:id/tvItemName")
    private WebElement productName;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"wrteam.multivendor.customer:id/lytTax\"]/following-sibling::android.widget.TextView")
    private WebElement totalPrice;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Subtotal\"]")
    private WebElement subTotalText;

    @FindBy(id = "wrteam.multivendor.customer:id/tvSubTotal")
    private WebElement subTotal;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Delivery Charge\"]")
    private WebElement deliveryChargeText;

    @FindBy(id = "wrteam.multivendor.customer:id/tvDeliveryCharge")
    private WebElement deliveryChargeValue;

    @FindBy(xpath = "//android.widget.TextView[@text=\"You saved \"]")
    private WebElement youSavedText;

    @FindBy(id = "wrteam.multivendor.customer:id/tvSaveAmount")
    private WebElement youSavedValue;

    private boolean verifyShippingDetailDisplay(String pinCode){
        wait.until(ExpectedConditions.visibilityOf(shippingDetail));
        return shippingDetail.isDisplayed()&& addressText.getAttribute("text").contains(pinCode);
    }

    private boolean verifyDeliveryDateTime(){
        return deliveryDateTime.isDisplayed();
    }

    private boolean verifyGrandTotal(String grandTotal){
        return grandTotalText.isDisplayed()
                && grandTotalValue.getAttribute("text").equals(grandTotal);
    }

    public boolean verifyOrderSummary(String name, String totalP, String sub, String deliveryC, String save){
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.scrollToOrderSummary(driver);
            return orderSummary.isDisplayed() &&
                    productName.getAttribute("text").equals(name)
                    && totalPrice.getAttribute("text").equals(totalP)
                    && subTotalText.isDisplayed() && subTotal.getAttribute("text").equals(sub)
                    && deliveryChargeText.isDisplayed() && deliveryChargeValue.getAttribute("text").equals(deliveryC)
                    && youSavedText.isDisplayed() && youSavedValue.getAttribute("text").equals(save);
    }

    public boolean verifyPaymentScreen(String pinCode, String grandTotal){
        return verifyShippingDetailDisplay(pinCode)
                && verifyDeliveryDateTime()
                && verifyGrandTotal(grandTotal);
    }





}
