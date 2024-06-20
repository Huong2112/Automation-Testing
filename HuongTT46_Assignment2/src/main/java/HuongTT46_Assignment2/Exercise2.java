package HuongTT46_Assignment2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise2 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setChromedriverExecutable("D:\\SELENIUM\\chromedriver.exe")
                .setAutomationName("UiAutomator2")
                .setCapability(CapabilityType.BROWSER_NAME,"chrome");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.lazada.vn/");
    }
}
