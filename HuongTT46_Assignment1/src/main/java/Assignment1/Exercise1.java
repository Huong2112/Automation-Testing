package Assignment1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise1 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName("UiAutomator2")
        .setPlatformName("Android")
                .setUdid("DU495D5TZTZPQ4RG")
                .setAppPackage("com.shopstyle")
                .setAppActivity("com.shopstyle.activity.HomeActivity");
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));

        //Step 2: Click to the “Skip” button.
        WebElement skipButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/skipText")));
        skipButton.click();

        //Step 3: Click to the “Shop Men's Fashion”.
        WebElement shopMenFashion = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/btnMale")));
        shopMenFashion.click();


        //Step 4: Click to the “Categories”.
        WebElement categories = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Categories\"]")));
        categories.click();

        //Step 5: Click to the “Bags”.
        WebElement bags = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\" and @text=\"Bags\"]")));
        bags.click();

        //Step 6: Click to the “Backpacks”.
        WebElement backPacks = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\" and @text=\"Backpacks\"]")));
        backPacks.click();

        //Step 7: Click to the first item
        WebElement fistItem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.shopstyle:id/productCardLayout\"])[1]")));
        fistItem.click();

        //Step 8: Verify product price and product name should be displayed.
        WebElement productPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/sale_price")));
        productPrice.isDisplayed();

        WebElement productName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/productBrand")));
        productName.isDisplayed();

        androidDriver.quit();
    }
}
