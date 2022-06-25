package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;

public class FilterPageAndroid {

    public FilterPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    // Strings
    String filter = "FİLTRE";

    // Elements
    By filterLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By colourButton = By.xpath("//android.widget.TextView[@text='Renk']");
    By listFilterResultsButton = By.id("com.lcwaikiki.android:id/buttonFilter");

    // Methods
    public void checkFilterLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(filterLabel), filter);
    }

    public void clickColourButton() {
        elementHelperAndroid.click(colourButton);
    }

    public void clickListerFilterResultsButton() {
        elementHelperAndroid.click(listFilterResultsButton);
    }

}
