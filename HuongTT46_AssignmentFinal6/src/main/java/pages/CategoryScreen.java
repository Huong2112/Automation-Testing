package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryScreen extends AppiumBase {
    public CategoryScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/tvTitle")
    private List<WebElement> listCategories;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\" Fast Food\"]")
    private WebElement fastFood;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Beverages\"]")
    private WebElement beverages;


    public boolean verifySixCategory(int expectedNumber, String coffee, String fastfood, String homeSupply, String beverage, String babyNeeds, String vegetable){
        boolean result = true;
        List<String> expectedList = Arrays.asList(new String[]{coffee,fastfood,homeSupply,beverage, babyNeeds, vegetable});
        Set<String> catgories = new HashSet<>();
        for (WebElement element : listCategories){
            catgories.add(element.getAttribute("text").trim());
        }
        if (catgories.size() != expectedNumber){
            result  = false;
        }else {
            for (String s : catgories){
                if (!expectedList.contains(s.trim())){
                    result = false;
                    break;
                }
            }
        }
        System.out.println(catgories.toString());
        return result;
    }

    public void clickToFastFood(){
        wait.until(ExpectedConditions.visibilityOf(fastFood)).click();
    }

    public void clickToBeverage(){
        wait.until(ExpectedConditions.visibilityOf(beverages)).click();
    }
}
