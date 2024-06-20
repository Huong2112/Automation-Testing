package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.interfaces.DSAPublicKey;

public class ProductDetailPage extends AppiumBase {
    public ProductDetailPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement productName;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement productPrice;

    @FindBy(id = "com.banggood.client:id/btn_slide_buy")
    private WebElement buyNowButton;

    @FindBy(id = "com.banggood.client:id/btn_slide_cart")
    private WebElement addToCartButton;

    @FindBy(id = "com.banggood.client:id/menu_cart_icon")
    private WebElement cartIcon;



    private boolean verifyPriceInRangeVND(String fromUSD, String toUSD){
        double from = Double.parseDouble(fromUSD);
        double to = Double.parseDouble(toUSD);
        String priceText = productPrice.getAttribute("text");
        String priceNumber =  priceText.replace(priceText.substring(0,3), "");
        double price = Double.parseDouble(priceNumber);
        if (!(price >= from && price<= to)){
            return false;
        }
        return true;
    }

    public boolean verifyProductNameAndPrice(String fromUSD, String toUSD){
        return wait.until(ExpectedConditions.visibilityOf(productName)).isDisplayed()
                && verifyPriceInRangeVND(fromUSD, toUSD);

    }

    public boolean verifyProductDetailScreen(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).isDisplayed()
                && productPrice.isDisplayed()
                && buyNowButton.isDisplayed()
                && addToCartButton.isDisplayed();
    }

    public void clickToCartIcon(){
        wait.until(ExpectedConditions.visibilityOf(cartIcon)).click();
    }

    public void clickToAddToCartButton(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
    }


}
