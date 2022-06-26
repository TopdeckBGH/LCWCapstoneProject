package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;
import utils.enums.PriceLabels;

import java.util.concurrent.TimeUnit;

public class SearchResultsPageAndroid {

    public SearchResultsPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    public static int productNumber = 1;

    // Strings
    String blouseResults = "Bluz";
    String product = "//*[contains(@class,\"RecyclerView\")][2]/*[contains(@class,\"android.view.ViewGroup\")][";
    String inCart = "//android.widget.TextView[@text='Sepette']";
    String discount = "//android.widget.TextView[@text='İndirim']";
    String discountPrice = "//android.widget.TextView[contains(@resource-id,\"DiscountPrice\")]";
    String noDiscountPrice = "//android.widget.TextView[contains(@resource-id,\"product_Price\")]";
    public static String price;

    // Elements
    By blouseResultsLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By filterButton = By.id("com.lcwaikiki.android:id/filter_text");

    // Methods
    public String getDiscountType() {
        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (elementHelperAndroid.assertElementIsVisible(elementUpdater(PriceLabels.CartPrice, productNumber))){
            return price = elementHelperAndroid.getText(By.xpath(product + productNumber + "]" + discountPrice));
        }
        else if (elementHelperAndroid.assertElementIsVisible(elementUpdater(PriceLabels.DiscountedPrice, productNumber))) {
            return price = elementHelperAndroid.getText(By.xpath(product + productNumber + "]" + discountPrice));
        }
        else{
            return price = elementHelperAndroid.getText(By.xpath(product + productNumber + "[" + noDiscountPrice));
        }
    }

    public By elementUpdater(PriceLabels priceLabels, int productNumber){
        switch(priceLabels) {
            case Element:
                return By.xpath( product + productNumber + "]");
            case CartPrice:
                return By.xpath(product + productNumber + "]" + inCart);
            case DiscountedPrice:
                return By.xpath(product + productNumber + "]" + discount);
            default:
                return  null;
        }
    }

    public void checkBlouseResultsLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(blouseResultsLabel), blouseResults);
    }

    public void clickFilterButton() {
        elementHelperAndroid.click(filterButton);
    }

    public void clickFirstProductButton() {
        getDiscountType();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementHelperAndroid.click(elementUpdater(PriceLabels.Element, productNumber));
    }
}
