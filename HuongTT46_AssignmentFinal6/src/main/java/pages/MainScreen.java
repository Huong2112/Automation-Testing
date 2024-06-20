package pages;

import core.AppiumBase;
import core.ScrollTapUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainScreen extends AppiumBase {
    public MainScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/navMain")
    private WebElement homeIcon;

    @FindBy(id = "wrteam.multivendor.customer:id/navCategory")
    private WebElement category;

    @FindBy(id = "wrteam.multivendor.customer:id/navProfile")
    private WebElement profile;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Fresh Vagetables\"]/../following-sibling::androidx.recyclerview.widget.RecyclerView/descendant::android.widget.TextView[contains(@resource-id,\"wrteam.multivendor.customer:id/tvStyle2\")]")
    private List<WebElement> listFreshVegetable;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Fresh Vagetables\"]/following-sibling::android.widget.TextView[@text=\"View All\"]")
    private WebElement viewAllFreshV;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Coffee\"]/following-sibling::android.widget.TextView[@text=\"View All\"]")
    private WebElement viewAllInCoffee;

    @FindBy(id = "wrteam.multivendor.customer:id/searchView")
    private WebElement searchView;



    public void clickToCategory(){
        wait.until(ExpectedConditions.visibilityOf(category)).click();
    }

    public void clickToMain(){
        wait.until(ExpectedConditions.visibilityOf(homeIcon)).click();
        Actions actions = new Actions(driver);
        actions.click(homeIcon).perform();
       driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void clickToProfile(){
        wait.until(ExpectedConditions.visibilityOf(profile)).click();
    }

    public void scrollIntoFreshVegetables(){
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.swipeNTime(4, driver);
    }

    public boolean verifyDisplayNProduct(int n){
        wait.until(ExpectedConditions.visibilityOfAllElements(listFreshVegetable));
        if (listFreshVegetable.size() != n){
            return false;
        }
        return true;

    }

    public void clickToViewAllInFreshVegetables(){
        wait.until(ExpectedConditions.visibilityOf(viewAllFreshV)).click();
    }

    public void scrollToCoffee(){
        wait.until(ExpectedConditions.visibilityOf(searchView));
        ScrollTapUtils scrollTapUtils = new ScrollTapUtils();
        scrollTapUtils.swipeNTime(4, driver);
    }
    public void clickToViewAllInCoffee(){
        wait.until(ExpectedConditions.visibilityOf(viewAllInCoffee)).click();
    }










}
