package HuongTT46_Assignment2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise4 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAppPackage("vn.tiki.app.tikiandroid")
                .setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity")
                .setAutomationName("UiAutomator2");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement denyLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_deny_button")));
        denyLocation.click();

        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid:id/navCategories")));
        category.click();


        WebElement phone_tablet =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id= 'vn.tiki.app.tikiandroid.category2:id/tvContent' and @text= 'Điện Thoại - Máy Tính Bảng']")));
        phone_tablet.click();

        WebElement tablet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='vn.tiki.app.tikiandroid.category2:id/tvTitle' and @text='Máy tính bảng']")));
        tablet.click();

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid:id/productV2Image")));
        firstProduct.click();

        WebElement productImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid.productDetail2:id/image")));
        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='pdp_product_name']")));
        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid.productDetail2:id/text_price")));
        WebElement BuyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid.productDetail2:id/button_buy_now")));

        Assert.assertTrue(productImg.isDisplayed());
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
        Assert.assertTrue(BuyNowButton.isDisplayed());

        driver.quit();
    }
}
