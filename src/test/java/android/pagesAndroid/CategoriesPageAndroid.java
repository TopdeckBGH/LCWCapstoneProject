package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

public class CategoriesPageAndroid {

    public CategoriesPageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelper = new ElementHelper(appiumDriver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Elements


    // Methods
}
