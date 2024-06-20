package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FreshVegetableListScreen extends AppiumBase {
    public FreshVegetableListScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/productName")
    private List<WebElement> listProducts;


    public boolean verifyDisplayNproduct(int expectedNumber){
        Set<String> listProductName = new HashSet<>();
        for (WebElement element : listProducts){
            listProductName.add(element.getAttribute("text"));
        }
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.swipeNTime(1, driver);

        for (WebElement element : listProducts){
            listProductName.add(element.getAttribute("text"));
        }
        System.out.println(listProductName.size());
        return listProductName.size() == expectedNumber;
    }
}
