package pages;

import core.AppiumBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends AppiumBase {
    public SearchPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @FindBy(xpath = "//android.widget.EditText[@text=\"What are you looking for?\"]")
    private WebElement searchText;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"View Details\"])/..")
    private List<WebElement> listProduct;

    public void search(String keys)  {
        wait.until(ExpectedConditions.visibilityOf(searchText)).click();
        searchText.sendKeys(keys);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
    }

    public boolean verifySearchResults(int numberOfProducts){
        int actual = wait.until(ExpectedConditions.visibilityOfAllElements(listProduct)).size();
        return actual == numberOfProducts;

    }

}
