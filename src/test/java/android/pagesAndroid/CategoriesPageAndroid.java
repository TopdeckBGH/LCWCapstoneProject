package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.ElementHelperAndroid;

import java.time.Duration;

public class CategoriesPageAndroid {

    public CategoriesPageAndroid(AppiumDriver appiumDriver) {
        //this.driver = appiumDriver;
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelper = new ElementHelperAndroid(appiumDriver);
        this.action = new TouchAction(appiumDriver);
    }

    //WebDriver driver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;
    AppiumDriver appiumDriver;
    TouchAction action;

    // Strings
    String categories = "Kategoriler";

    // Elements
    By categoriesLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By clothingButton = By.xpath("//android.widget.TextView[@text='Giyim']");
    By blouseButton = By.xpath("//android.widget.TextView[@text='Bluz']");
    public void dragAndDropElement(int firstX, int firstY, int lastX, int lastY) {
        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(firstX,firstY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                .moveTo(PointOption.point(lastX, lastY))
                .release()
                .perform();
    }

    // Methods
    public void checkCategoriesLabel() {
        Assert.assertEquals(elementHelper.getText(categoriesLabel), categories);
    }

    public void clickClothingButton() {
        elementHelper.click(clothingButton);
    }

    public void clickBlouseButton() {
        dragAndDropElement(125, 1750, 125, 762);
        elementHelper.click(blouseButton);
    }

}
