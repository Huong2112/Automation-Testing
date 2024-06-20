package pages;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreen extends AppiumBase {
    public HomeScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "wrteam.multivendor.customer:id/tvSkip")
    private WebElement skipButton;

    @FindBy(id = "wrteam.multivendor.customer:id/tvNext")
    private WebElement nextButton;

    @FindBy(id = "wrteam.multivendor.customer:id/tvNext")
    private WebElement getStarted;

    @FindBy(id = "wrteam.multivendor.customer:id/tvMessage")
    private WebElement text;

    public boolean verifyWelcomeScreen(String expectedMessage){
        return wait.until(ExpectedConditions.visibilityOf(skipButton)).isDisplayed()
                && nextButton.isDisplayed()
                && text.isDisplayed()
                && text.getText().equals(expectedMessage);
    }

    public void clickToNext(){
        wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
    }
    public void clickToGetStarted(){
        wait.until(ExpectedConditions.visibilityOf(getStarted)).click();
    }

}
