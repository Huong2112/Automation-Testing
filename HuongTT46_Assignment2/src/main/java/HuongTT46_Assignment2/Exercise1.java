package HuongTT46_Assignment2;

import com.sun.nio.file.ExtendedOpenOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Exercise1 {
    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAutomationName("UiAutomator2")
                .setChromedriverExecutable("D:\\SELENIUM\\chromedriver.exe");
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://www.google.com");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("appium testing");

        WebElement firstSuggest = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@jsname = 'IrQt0b']")));
        firstSuggest.click();

        WebElement firstResult = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'N54PNb BToiNc cvP2Ce')]")));
        firstResult.click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Welcome - Appium Documentation");

        driver.quit();
    }


}
