package Demo;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class ScrollDemo {

    AndroidDriver androidDriver;
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();


        options.setPlatformName("Android")
                .setUdid("R58T349Q8LX")
                .setAutomationName("UiAutomator2")
                .setChromedriverExecutable("D:\\selenium\\chromedriver.exe")
                .setAppPackage("com.company.rawal")
                .setAppActivity("com.company.rawal.MainActivity");

        androidDriver= new AndroidDriver(new URL("http://localhost:4723"), options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        swipeMobileUp();
        swipeMobileUp();

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
        androidDriver.perform(Arrays.asList(dragNDrop));
    }
    public void swipeMobileUp() {
        Dimension screenSize = androidDriver.manage().window().getSize();
        int starty = (int) (screenSize.height * 0.8);
        int endy = (int) (screenSize.height * 0.2);
        int startx = screenSize.width / 2;
        swipe(startx, starty, startx, endy);
    }


}
