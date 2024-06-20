package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AppiumBase {
    public CartPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement productName;

    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement productPrice;

    @FindBy(id = "com.banggood.client:id/edit_qty")
    private WebElement quantity;

    public boolean verifyProductInCart(){
        return productName.isDisplayed()
                && productPrice.isDisplayed()
                && quantity.isDisplayed();
    }

}
