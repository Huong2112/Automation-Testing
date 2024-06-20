package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class SearchPage extends BasePage {

    public SearchPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"What are you looking for?\"]")
    private WebElement searchInput;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"View Details\"])/..")
    private List<WebElement> textInProducts;

    public void search(String keys) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(keys);
        getAndroidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(1000);
    }

    public boolean verifySearchResults(String product1, String product2){
        boolean result = true;
        if (textInProducts.size() == 2){
            for (WebElement we : textInProducts){
                if (!we.getText().contains(product1) && !we.getText().contains(product2)){
                    result = false;
                }
            }
        }
        else {
            result = false;

        }
        return result;

    }
}
