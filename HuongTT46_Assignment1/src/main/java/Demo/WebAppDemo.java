package Demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebAppDemo {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setUdid("emulator-5554")
                .setChromedriverExecutable("D:\\selenium\\chromedriver.exe");
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost4723"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.google.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("Automation Test");
        Thread.sleep(3000);
    }
}
