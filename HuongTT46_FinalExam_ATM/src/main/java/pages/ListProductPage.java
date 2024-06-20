package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ListProductPage extends AppiumBase {
    public ListProductPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_filter_label\"]")
    private WebElement filter;


    @FindBy(id = "com.banggood.client:id/edit_price_min")
    private WebElement minPrice;

    @FindBy(id = "com.banggood.client:id/edit_price_max")
    private WebElement maxPrice;

    @FindBy(id = "com.banggood.client:id/btn_done")
    private WebElement doneButton;

    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement firstProduct;
//    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_product_name\" ])[2]")
//    private WebElement fist2Product;

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.banggood.client:id/item_view\"])[2]/android.view.ViewGroup")
    private WebElement fist2Product;




    public void clickToFilter(){
        wait.until(ExpectedConditions.visibilityOf(filter)).click();
    }


    public void inputPrice(String min, String max){
        wait.until(ExpectedConditions.visibilityOf(minPrice)).click();
        minPrice.sendKeys(min);
        wait.until(ExpectedConditions.visibilityOf(maxPrice)).click();
        maxPrice.sendKeys(max);

    }

    public void clickToDoneButton(){
        wait.until(ExpectedConditions.visibilityOf(doneButton)).click();
    }

    public void clickToFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProduct)).click();
    }


    public void clickTo2ndProduct(){
        //Because first product is out of stock
        wait.until(ExpectedConditions.visibilityOf(fist2Product)).click();
    }


}
