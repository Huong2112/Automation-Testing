package core;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private AndroidDriver androidDriver;
    private WebDriverWait wait;

    public BasePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(androidDriver, this);
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
