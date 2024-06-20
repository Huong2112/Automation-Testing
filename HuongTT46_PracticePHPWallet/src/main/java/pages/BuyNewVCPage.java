package pages;

import core.AppiumBase;
import core.ScrollUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuyNewVCPage extends AppiumBase {
    public BuyNewVCPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText")
    private WebElement nameOnCard;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Fund your new Virtual Card\"]")
    private WebElement fundButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"0\"]")
    private WebElement amountText;

    @FindBy(xpath = "//android.widget.Button")
    private WebElement nextIcon;

    @FindBy(xpath = "//android.widget.EditText/../../following-sibling::android.view.View/descendant::android.view.View")
    private WebElement message;

    public void enterNameOnCard(String name){
        WebElement nameOn =  wait.until(ExpectedConditions.visibilityOf(nameOnCard));
        nameOn.click();
        nameOn.sendKeys(name);
    }

    public void clickToFundButton(){
        fundButton.click();
    }

    public void enterAmount(String a){
        ScrollUtils scrollUtils =  new ScrollUtils();
        scrollUtils.tap2(driver);

       WebElement amount =  wait.until(ExpectedConditions.visibilityOf(amountText));
       //amount.clear();
       amount.sendKeys(a);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
    }
    public void clickToNextIcon(){
        nextIcon.click();
    }

    public boolean verifyMessage(String expectedMessage){
        String actualMessage = wait.until(ExpectedConditions.visibilityOf(message)).getAttribute("content-desc");
        System.out.println(actualMessage);
        return actualMessage.equals(expectedMessage);
    }

    public boolean verifyBuyNewCardScreen(){
        return wait.until(ExpectedConditions.visibilityOf(nameOnCard)).isDisplayed()
                && fundButton.isDisplayed();
    }
}
