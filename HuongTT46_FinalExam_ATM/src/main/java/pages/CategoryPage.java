package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;



public class CategoryPage extends AppiumBase {
    public CategoryPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_name\" and @text=\"Home and Garden\"]")
    private WebElement homeAndGarden;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_title\" and @text=\"Home Decor\"]")
    private WebElement homeDecor;




    public void clickToHomeAndGarden(){
        try {
            wait.until(ExpectedConditions.visibilityOf(homeAndGarden)).click();
        }catch (Exception e){
            ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
            scrollTapUtils.lightScrollInLeftMenu(driver);
            wait.until(ExpectedConditions.visibilityOf(homeAndGarden)).click();
        }
    }


    public void clickToHomeDecor(){
        wait.until(ExpectedConditions.visibilityOf(homeDecor)).click();
    }



}