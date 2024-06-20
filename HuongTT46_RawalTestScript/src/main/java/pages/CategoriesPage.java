package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends BasePage {
    public CategoriesPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Men']")
    private WebElement men;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Women']")
    private WebElement women;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Kid']")
    private WebElement kid;

    public boolean verifyCategoryScreen(){
       return getWait().until(ExpectedConditions.visibilityOf(men)).isDisplayed()
               && women.isDisplayed()
               && kid.isDisplayed();
    }

}
