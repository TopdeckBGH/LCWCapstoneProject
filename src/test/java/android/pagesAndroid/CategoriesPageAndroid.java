package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    // Strings
    String categories = "Kategoriler";

    // Elements
    By categoriesLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By clothingButton = By.xpath("//android.widget.TextView[@text='Giyim']");
    By blouseButton = By.xpath("//android.widget.TextView[@text='Bluz']");

    // Methods
    public void checkCategoriesLabel() {
        Assert.assertEquals(elementHelper.getText(categoriesLabel), categories);
    }

    public void clickClothingButton() {
        elementHelper.click(clothingButton);
    }

    public void clickBlouseButton() {
        elementHelper.click(blouseButton);
    }

}
