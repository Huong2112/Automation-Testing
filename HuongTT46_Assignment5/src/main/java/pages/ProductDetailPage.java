package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends AppiumBase {
    public ProductDetailPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"pdp_product_name\"]")
    private WebElement productName;

    @FindBy(id = "vn.tiki.app.tikiandroid.productDetail2:id/text_price")
    private WebElement productPrice;

    public boolean verifyNameAndPriceDisplay(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).isDisplayed()
                && productPrice.isDisplayed();
    }
}
