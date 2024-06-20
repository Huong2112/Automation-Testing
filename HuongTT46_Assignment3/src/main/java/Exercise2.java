import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Exercise2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAppPackage("vn.tiki.app.tikiandroid")
                .setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity")
                .setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void test() throws InterruptedException {
        //Step 2: Click Danh Muc San Pham
        WebElement denyLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_deny_button")));
        denyLocation.click();

        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid:id/navCategories")));
        category.click();

        //Step 3: Scroll to “Hàng Quốc Tế” in Left menu
        swipeMobileUp();
        swipeMobileUp();
        swipeMobileUp();
        WebElement hangQuocTe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvContent\" and @text=\"Cross Border - Hàng Quốc Tế\"]")));
        hangQuocTe.click();

        //Step 4: Scroll to panel “Laptop & Máy Vi Tính”
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();

        //Step 5: Click to the “Laptop”
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Laptop\"]"))).click();

        //Step 6: Click to the first product.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid:id/productV2Image"))).click();


        //Step 7: Scroll to the “Thông tin chi tiết”
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();
        swipeMobileUp1();

        //Step 8: Verify “Danh mục”, “Thương Hiệu”, “Nơi Sản Xuất” and “SKU” would be displayed.
        WebElement danhMuc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vn.tiki.app.tikiandroid.productDetail2:id/tvTitle")));
        Assert.assertTrue(danhMuc.isDisplayed());

        WebElement thuongHieu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvName\" and @text=\"Thương hiệu\"]")));
        Assert.assertTrue(thuongHieu.isDisplayed());

        WebElement sku = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvName\" and @text=\"Xuất xứ thương hiệu\"]")));
        Assert.assertTrue(sku.isDisplayed());

        WebElement noiSanXuat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvName\" and @text=\"Xuất xứ (Made in)\"]")));
        Assert.assertTrue(noiSanXuat.isDisplayed());

    }
    @AfterTest
    public void afterTest(){
        if (driver != null){
            driver.quit();
        }
    }

    public void swipe(int startx, int starty, int endx, int endy) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startx, starty));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endx, endy));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }
    public void swipeMobileUp() {
        Dimension screenSize = driver.manage().window().getSize();
        int starty = (int) (screenSize.height * 0.8);
        int endy = (int) (screenSize.height * 0.2);
        int startx = (int) (screenSize.width * 0.2);
        swipe(startx, starty, startx, endy);
    }

    public void swipeMobileUp1(){
        Dimension screenSize = driver.manage().window().getSize();
        int starty = (int) (screenSize.height * 0.7);
        int endy = (int) (screenSize.height * 0.3);
        int startx = (int) (screenSize.width * 0.5);
        swipe(startx, starty, startx, endy);
    }
}
