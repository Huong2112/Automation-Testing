package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchProductScreen extends AppiumBase {
    public SearchProductScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/searchView\"]")
    private WebElement searchBox;

//    @FindBy(id = "wrteam.multivendor.customer:id/btnAddToCart")
//    private WebElement addToCartButton;

    @FindBy(xpath = "(//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnAddToCart\"])[2]")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnAddToCart\"])[3]")
    private WebElement addButtonOfBeverage;


    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"eCart Multi Vendor - Customer\"])[6]")
    private WebElement beveragePlusButton;
    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"eCart Multi Vendor - Customer\"])[4]")
    private WebElement plusButton;

    @FindBy(id = "wrteam.multivendor.customer:id/toolbar_cart")
    private WebElement cartIcon;

    @FindBy(id = "wrteam.multivendor.customer:id/imgThumb")
    private WebElement productByName;


    private void searchProduct(String key){
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(key);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();

    }

    public void addProductToCart(int quantity, String name ){
        searchProduct(name);
        wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
            for (int i = 1; i < quantity; i++){
                wait.until(ExpectedConditions.visibilityOf(plusButton)).click();
            }
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
    }


    public void addSunfeastDarkProductToCart(int quantity, String name ){
        searchProduct(name);
        wait.until(ExpectedConditions.visibilityOf(addButtonOfBeverage)).click();
        for (int i = 1; i < quantity; i++){
            wait.until(ExpectedConditions.visibilityOf(beveragePlusButton)).click();
        }
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
    }

    public void clickToCartIcon(){
        cartIcon.click();
    }

    public void searchAndClickToProduct(String name){
        searchProduct(name);
        wait.until(ExpectedConditions.visibilityOf(productByName)).click();
    }
}
