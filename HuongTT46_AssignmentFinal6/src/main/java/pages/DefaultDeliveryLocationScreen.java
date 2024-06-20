package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.initialization.qual.FBCBottom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DefaultDeliveryLocationScreen extends AppiumBase {
    public DefaultDeliveryLocationScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @FindBy(id = "wrteam.multivendor.customer:id/searchView")
    private WebElement searchPinTextBox;

    @FindBy(id = "wrteam.multivendor.customer:id/tvSearch")
    private WebElement searchButton;

    @FindBy(id = "wrteam.multivendor.customer:id/tvPinCode")
    private List<WebElement> listLocation;

    @FindBy(id = "wrteam.multivendor.customer:id/tvPinCode")
    private WebElement firstLocation;

    private boolean verifyLocationDisplay(List<String> expectedLocation){
        boolean results = true;
        for (int i = 0; i < listLocation.size(); i++){
            if (!(listLocation.get(i).getAttribute("text").equals(expectedLocation.get(i)))){
                results = false;
                break;
            }
        }
        return  results;
    }

    public boolean verifyDefaultDeliveryLocationDisplay(List<String> expectedLocation){
        return wait.until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed()
                && searchButton.isDisplayed()
                && verifyLocationDisplay(expectedLocation);
    }

    public void searchAndSelectLocation(String location){
        WebElement search = wait.until(ExpectedConditions.visibilityOf(searchPinTextBox));
        search.click();
        search.sendKeys(location);
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstLocation)).click();
    }

    public boolean checkLocationDisplay(){
        try {
           if (wait.until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed()){
               return true;
           }else {
               return false;
           }
        }catch (Exception e){
            return false;
        }
    }


}
