package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.androidUtils.DriverFactoryAndroid;
import utils.androidUtils.ElementHelperAndroid;

import java.util.concurrent.TimeUnit;

public class ProductPageAndroid {

    public ProductPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    SearchResultsPageAndroid searchResultsPageAndroid = new SearchResultsPageAndroid(DriverFactoryAndroid.getAppDriver());

    // Strings

    // Elements
    By upArrowButton = By.id("com.lcwaikiki.android:id/scrollImage");
    By sizeMButton = By.xpath("//android.widget.TextView[@text='M']");
    By addToCartButton = By.id("com.lcwaikiki.android:id/basket");
    By goToCartButton = By.xpath("//android.widget.TextView[@text='Sepete Git']");
    By noStockM = By.xpath("//android.widget.FrameLayout[@content-desc='Tükendi'] //*[@text= 'M']");




    // Methods
    public void clickUpArrowButton() {
        elementHelperAndroid.click(upArrowButton);
    }

    public void clickSizeMButton() {
        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        while (elementHelperAndroid.assertElementIsVisible(noStockM)){
            appiumDriver.navigate().back();
            SearchResultsPageAndroid.productNumber++;
            searchResultsPageAndroid.clickFirstProductButton();
        }
        elementHelperAndroid.click(sizeMButton);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void clickAddToCartButton() {
        elementHelperAndroid.click(addToCartButton);
    }

    public void clickGoToCartButton() {
        elementHelperAndroid.click(goToCartButton);
    }


}
