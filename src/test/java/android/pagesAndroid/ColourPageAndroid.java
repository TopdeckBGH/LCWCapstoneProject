package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;

public class ColourPageAndroid {

    public ColourPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    // Strings
    String colourFilter = "RENK";

    // Elements
    By colourFilterLabel = By.id("com.lcwaikiki.android:id/toolbarTitle") ;
    By blackColourFilterButton = By.xpath("//android.widget.TextView[@text='Siyah']");
    By applyButton = By.xpath("//android.widget.TextView[@text='UYGULA']");

    // Methods
    public void checkColourFilterLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(colourFilterLabel), colourFilter);
    }

    public void clickBlackColourFilterButton() {
        elementHelperAndroid.dragAndDropElement(500, 500, 0, 0);
        elementHelperAndroid.click(blackColourFilterButton);
    }

    public void clickApplyButton () {
        elementHelperAndroid.click(applyButton);
    }

}
