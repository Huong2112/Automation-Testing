package Assignment1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise3 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName("UiAutomator2")
                .setUdid("DU495D5TZTZPQ4RG")
                .setPlatformName("Android")
                .setAppPackage("com.shopStyle")
                .setAppActivity("com.shopStyle.activity.HomeActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Step 2: Click to the “Skip” button.
        WebElement skipButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/skipText")));
        skipButton.click();

        //Step 3: Click to the “Shop Men's Fashion”.
        WebElement shopMenFashion = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/btnFemale")));
        shopMenFashion.click();

        // Step 4: Click to the “Brands”
        WebElement brands = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Brands\"]"))); // BRANDS
        brands.click();

        //Step 5: Click to the first brands
        WebElement firstBrand = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\" and @text=\"A Bathing Ape\"]"))); //com.shopstyle:id/filterName
        firstBrand.click();
        //Step 6: Verify Newest, On Sale and Lowest Price should be displayed.

        WebElement newest = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Newest\"]")));
        Assert.assertTrue(newest.isDisplayed());

        WebElement onSale = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"On Sale\"]")));
        Assert.assertTrue(onSale.isDisplayed());

        WebElement lowestPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Lowest Price\"]")));
        Assert.assertTrue(lowestPrice.isDisplayed());


    }
}
