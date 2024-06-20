package Assignment1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise2 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setAutomationName("UiAutomator2")
                .setUdid("DU495D5TZTZPQ4RG")
                .setPlatformName("Android")
                .setAppPackage("com.shopstyle")
                .setAppActivity("com.shopstyle.activity.HomeActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Step 2: Click to the “Skip” button.
        WebElement skipButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/skipText")));
        skipButton.click();

        //Step 3: Click to the “Shop Women's Fashion”.
        WebElement shopMenFashion = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/btnFemale")));
        shopMenFashion.click();

        //Step 4 -5 : Click to the Menu icon on top ==> setting
        WebElement menuIconOnTop = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/toolbarSettings")));
        menuIconOnTop.click();


        //Step 6: Verify the Account, Preferences should be displayed.
        WebElement account = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/list_item_section_text\" and @text=\"ACCOUNT\"]")));
        Assert.assertTrue( account.isDisplayed());

        WebElement preferences = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/list_item_section_text\" and @text=\"PREFERENCES\"]")));
        Assert.assertTrue(preferences.isDisplayed());

    }
}
