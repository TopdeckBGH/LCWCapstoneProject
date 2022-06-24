package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

public class TutorialPageAndroid {

    public TutorialPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Elements
    By skipButton = By.id("com.lcwaikiki.android:id/tvNext");

    // Methods
    public void clickSkipButton() {
        elementHelper.click(skipButton);
    }

}
