package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends AppiumBase {
    public CategoryPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Laptop - Máy Vi Tính - Linh kiện\"]")
    private WebElement laptopMayViTinhRight;


    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Điện Thoại - Máy Tính Bảng\"]")
    private WebElement dienThoaiMayTinhBangRight;

    public void clickToLaptopMayViTinhRight(){
        wait.until(ExpectedConditions.visibilityOf(laptopMayViTinhRight)).click();
    }

    public void scrollToLaptopMayViTinhRight() throws InterruptedException {
        Thread.sleep(500);
        ScrollUtils scrollUtils = new ScrollUtils();
        scrollUtils.swipeNTime(1, driver);
    }

    public void clickToDienThoaiMayTinhBangRight(){
        wait.until(ExpectedConditions.visibilityOf(dienThoaiMayTinhBangRight)).click();
    }

}
