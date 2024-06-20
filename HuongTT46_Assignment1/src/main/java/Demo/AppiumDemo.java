package Demo;

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

public class AppiumDemo {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2")
                .setUdid("DU495D5TZTZPQ4RG")
                .setPlatformName("Android")
                .setAppPackage("com.shopstyle")
                .setAppActivity("com.shopstyle.activity.HomeActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        WebElement skipButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.shopstyle:id/skipText")));
        skipButton.click();
        androidDriver.quit();
    }
}
