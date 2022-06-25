package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.androidUtils.ElementHelperAndroid;

public class ProductPageAndroid {

    public ProductPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    // Strings

    // Elements
    By upArrowButton = By.id("com.lcwaikiki.android:id/scrollImage");
    By sizeMButton = By.xpath("//android.widget.TextView[@text='M']");
    By addToCartButton = By.id("com.lcwaikiki.android:id/basket");
    By goToCartButton = By.xpath("//android.widget.TextView[@text='Sepete Git']");

    // Methods
    public void clickUpArrowButton() {
        elementHelperAndroid.click(upArrowButton);
    }

    public void clickSizeMButton() {
        elementHelperAndroid.click(sizeMButton);
    }

    public void clickAddToCartButton() {
        elementHelperAndroid.click(addToCartButton);
    }

    public void clickGoToCartButton() {
        elementHelperAndroid.click(goToCartButton);
    }


}
