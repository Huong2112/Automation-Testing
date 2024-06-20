package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {
    public static AndroidDriver driver ;
    public static WebDriverWait wait;

    public void createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAppPackage("vn.tiki.app.tikiandroid")
                .setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity")
                .setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void closeDriver(){
        driver.quit();
    }
}
