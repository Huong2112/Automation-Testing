package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListProductPage extends AppiumBase {
    public ListProductPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "vn.tiki.app.tikiandroid:id/productV2Image")
    private WebElement firstProduct;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Hàng mới\"]")
    private WebElement hangMoi;

    @FindBy(id = "vn.tiki.app.tikiandroid.productList2:id/filter_text")
    private WebElement locButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productList2:id/tv_name\" and @text=\"Samsung\"]")
    private WebElement samsung;

    @FindBy(id = "vn.tiki.app.tikiandroid.productList2:id/btn_apply")
    private WebElement apDungButton;




    public void scrollToBrand(){
        ScrollUtils scrollUtils = new ScrollUtils();
        scrollUtils.swipeNTime(1, driver);
    }

    public void clickToSamSung(){
        wait.until(ExpectedConditions.visibilityOf(samsung)).click();

    }

    public void clickToApDungButton(){
        wait.until(ExpectedConditions.visibilityOf(apDungButton)).click();
    }

    public void clickToFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProduct)).click();
    }

    public void clickToHangMoi(){
        wait.until(ExpectedConditions.visibilityOf(hangMoi)).click();
    }

    public void clickToLocButton() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(locButton)).click();
    }




}
