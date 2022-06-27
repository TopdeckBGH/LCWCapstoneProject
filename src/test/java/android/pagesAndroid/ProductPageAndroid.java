package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    String blouse = "Bluz";
    public static String productItemCode;
    public static String productItemTitle;

    // Elements
    By upArrowButton = By.id("com.lcwaikiki.android:id/scrollImage");
    By sizeMButton = By.xpath("//android.widget.TextView[@text='M']");
    By addToCartButton = By.id("com.lcwaikiki.android:id/basket");
    By goToCartButton = By.xpath("//android.widget.TextView[@text='Sepete Git']");
    By noStockM = By.xpath("//android.widget.FrameLayout[@content-desc='Tükendi'] //*[@text= 'M']");
    By noMoreItemLabel = By.id("com.lcwaikiki.android:id/dialogDescription");
    By okButton = By.id("com.lcwaikiki.android:id/completeButton");
    By closeButton = By.id("com.lcwaikiki.android:id/productClose");
    By itemPrice = By.id("com.lcwaikiki.android:id/price");
    By itemCode = By.id("com.lcwaikiki.android:id/modelCode");
    By itemTitle = By.id("com.lcwaikiki.android:id/productTitleText");


    // Methods
    public void clickUpArrowButton() {
        elementHelperAndroid.click(upArrowButton);
    }

    /**
     * If M size is out of stock, goes back to search a product with M size until it finds.
     */
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

    public void checkItemName(){
        productItemCode = elementHelperAndroid.getText(itemCode);
        productItemTitle = elementHelperAndroid.getText(itemTitle);
        Assert.assertTrue(productItemTitle.contains(blouse));
    }
    public void checkItemPrice(){
        Assert.assertEquals(elementHelperAndroid.getText(itemPrice), SearchResultsPageAndroid.price);
    }

    public void clickAddToCartButton() {
        elementHelperAndroid.click(addToCartButton);
    }

    public void clickGoToCartButton() {
        if(elementHelperAndroid.assertElementIsVisible(goToCartButton)){
            elementHelperAndroid.click(goToCartButton);
        }
        else if (elementHelperAndroid.assertElementIsVisible(noMoreItemLabel)){
            elementHelperAndroid.click(okButton);
            elementHelperAndroid.click(closeButton);
            SearchResultsPageAndroid.productNumber++;
            searchResultsPageAndroid.clickFirstProductButton();
            clickUpArrowButton();
            clickSizeMButton();
            checkItemName();
            clickAddToCartButton();
            clickGoToCartButton();
        }
    }


}
