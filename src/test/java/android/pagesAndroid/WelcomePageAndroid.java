package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.ElementHelperAndroid;

public class WelcomePageAndroid {

    public WelcomePageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelper = new ElementHelperAndroid(appiumDriver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;

    // Strings
    String welcomeText = "Hoş geldin";

    // Elements
    By welcomeLabel = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By profileButton = By.xpath("//android.widget.TextView[@text='Profil']");
    By categoriesButton = By.xpath("//android.widget.TextView[@text='Kategoriler']");

    public void checkWelcomeLabel() {
        Assert.assertEquals(elementHelper.getText(welcomeLabel), welcomeText);
    }

    public void clickProfileButton() {
        elementHelper.click(profileButton);
    }

    public void clickCategoriesButton() {
        elementHelper.click(categoriesButton);
    }

}
