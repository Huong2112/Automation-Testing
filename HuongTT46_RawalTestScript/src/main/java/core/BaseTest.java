package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.guieffect.qual.UI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private AndroidDriver driver;
    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAppPackage("com.company.rawal")
                .setAppActivity("com.company.rawal.MainActivity")
                .setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"),options);
    }
    @AfterTest
    public void afterTest(){
        if (driver != null){
            driver.quit();
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
