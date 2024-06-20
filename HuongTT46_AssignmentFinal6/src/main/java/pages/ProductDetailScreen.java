package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailScreen extends AppiumBase {
    public ProductDetailScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/tvProductName")
    private WebElement productName;

    @FindBy(id = "wrteam.multivendor.customer:id/tvPrice")
    private WebElement productPrice;

    @FindBy(id = "wrteam.multivendor.customer:id/btnAddToCart")
    private WebElement addToCartButton;

    @FindBy(id = "wrteam.multivendor.customer:id/btnCart")
    private WebElement goToCartButton;

    @FindBy(id = "wrteam.multivendor.customer:id/lytSimilar")
    private WebElement similarProductText;

    private boolean verifyProductName(String expectedName){
        return wait.until(ExpectedConditions.visibilityOf(productName)).isDisplayed()
                && productName.getAttribute("text").equals(expectedName);
    }

    private boolean verifyProductPrice(String expectedPrice){
        System.out.println(expectedPrice);
        System.out.println(productPrice.getAttribute("text"));
        return productPrice.isDisplayed()
                && productPrice.getAttribute("text").equals(expectedPrice);
    }

    private boolean verifySimilarProduct(){
        return similarProductText.isDisplayed();

    }

    public boolean verifyDetailScreenDisplay(String expName, String expPrice){
        return verifyProductName(expName) && verifyProductPrice(expPrice)
                && verifySimilarProduct() && goToCartButton.isDisplayed() && addToCartButton.isDisplayed();
    }


}
