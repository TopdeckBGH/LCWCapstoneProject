package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;
import utils.webUtils.ElementHelperWeb;

import java.time.Duration;

public class CategoriesPageAndroid {

    public CategoriesPageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(appiumDriver);
        this.action = new TouchAction(appiumDriver);
    }

    //WebDriver driver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;
    AppiumDriver appiumDriver;
    TouchAction action;

    // Strings
    String categories = "Kategoriler";

    // Elements
    By categoriesLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By clothingButton = By.xpath("//android.widget.TextView[@text='Giyim']");
    By blouseButton = By.xpath("//android.widget.TextView[@text='Bluz']");


    // Methods
    public void checkCategoriesLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(categoriesLabel), categories);
    }

    public void clickClothingButton() {
        elementHelperAndroid.click(clothingButton);
    }

    public void clickBlouseButton() {
        elementHelperAndroid.dragAndDropElement(125, 1750, 125, 762);
        elementHelperAndroid.click(blouseButton);
    }

}
