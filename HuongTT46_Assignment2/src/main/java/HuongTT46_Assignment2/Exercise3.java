package HuongTT46_Assignment2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAutomationName("UiAutomator2")
                .setChromedriverExecutable("D:\\SELENIUM\\chromedriver.exe")
                .setAppPackage("com.example.hybridtestapp")
                .setAppActivity("com.example.hybridtestapp.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/continue_button"))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();

        driver.context((String) driver.getContextHandles().toArray()[1]);
        String firstName = "Huong";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fname"))).sendKeys(firstName);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lname']"))).sendKeys("Tran");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']"))).sendKeys("16");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys("huongtran02");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='psw']"))).sendKeys("21122002");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register']"))).click();
        String actualText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))).getText();
        String expectedTex = "Registration Success!\nWelcome " + firstName;
        Assert.assertEquals(actualText, expectedTex);
        driver.quit();

    }
}
