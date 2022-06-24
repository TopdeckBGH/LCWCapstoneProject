package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementHelper;

public class WelcomePageAndroid {

    public WelcomePageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelper = new ElementHelper(appiumDriver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Strings
    String welcomeText = "Hoş geldin";

    // Elements
    By welcomeLabel = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By profileButton = By.xpath("//android.widget.TextView[@text='Profil']");

    public void checkWelcomeLabel() {
        Assert.assertEquals(appiumDriver.findElement(welcomeLabel).getText(), welcomeText);
    }

    public void clickProfileButton() {
        appiumDriver.findElement(profileButton).click();
    }

}
