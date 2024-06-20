package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class ScrollTapUtils {
    public ScrollTapUtils() {
    }

    private static void swipe(int startx, int starty, int endx, int endy, AndroidDriver driver) {
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
    public  void swipeMobileUp(AndroidDriver driver) {
        Dimension screenSize = driver.manage().window().getSize();
        int starty = (int) (screenSize.height * 0.8);
        int endy = (int) (screenSize.height * 0.1);
        int startx = (int) (screenSize.width * 0.5);
        swipe(startx, starty, startx, endy, driver);
    }

    public  void scrollToOrderSummary(AndroidDriver driver) {
        Dimension screenSize = driver.manage().window().getSize();
        int starty = (int) (screenSize.height * 0.5);
        int endy = (int) (screenSize.height * 0.1);
        int startx = (int) (screenSize.width * 0.5);
        swipe(startx, starty, startx, endy, driver);
    }

    public void swipeNTime(int n, AndroidDriver driver){
        for (int i = 0; i < n; i++){
            swipeMobileUp(driver);
        }
    }

}
