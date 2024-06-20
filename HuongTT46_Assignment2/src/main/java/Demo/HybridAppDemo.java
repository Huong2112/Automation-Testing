package Demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HybridAppDemo {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("")
                .setAutomationName("UiAutomator2")
                .setChromedriverExecutable("")
                .setAppPackage("com.example.hybridtestapp")
                .setAppActivity("com.example.hybridtestapp.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();

        driver.context((String) driver.getContextHandles().toArray()[1]);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fname"))).sendKeys("Demo");

        Thread.sleep(3000);
    }
}
