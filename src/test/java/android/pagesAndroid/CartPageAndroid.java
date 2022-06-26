package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;

public class CartPageAndroid {

    public CartPageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(appiumDriver);
    }

    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;
    AppiumDriver appiumDriver;

    // Strings
    String myCartPage = "Sepetim;";
    String size = "Beden";
    String colour = "Renk";
    String count = "Adet";
    String orderSummary = "SİPARİŞ ÖZETİ";

    // Elements
    By cartPageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By productItemTitle = By.id("com.lcwaikiki.android:id/itemBasketTitleText");
    By productItemCode = By.id("com.lcwaikiki.android:id/itemBasketCodeText");
    By productSizeLabel = By.id("com.lcwaikiki.android:id/itemBasketSizeToolText");
    By productSize = By.id("com.lcwaikiki.android:id/itemBasketSizeText");
    By productColourLabel = By.id("com.lcwaikiki.android:id/itemBasketColorToolText");
    By productColour = By.id("com.lcwaikiki.android:id/itemBasketColorText");
    By itemCountLabel = By.id("com.lcwaikiki.android:id/itemBasketCountToolsText");
    By itemCount = By.id("com.lcwaikiki.android:id/itemBasketCountText");
    By productItemPrice = By.id("com.lcwaikiki.android:id/itemBasketPrice");


    By upDownArrowButton = By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'com.lcwaikiki.android:id/rlSummar')][1]/android.widget.ImageView");
    By orderSummaryLabel = By.id("com.lcwaikiki.android:id/orderSummaryText");
    By productTotalSumLabel = By.id("com.lcwaikiki.android:id/totalLabelText");
    By productTotalSum = By.id("com.lcwaikiki.android:id/totalValueText");
    By subTotalSumLabel = By.id("com.lcwaikiki.android:id/subtotalLabelText");
    By subTotalSun = By.id("com.lcwaikiki.android:id/subtotalValueText");
    By shipmentFeeLabel = By.id("com.lcwaikiki.android:id/shippingLabelText");
    By shipmentFee = By.id("com.lcwaikiki.android:id/shippingValueText");
    By grandTotalSumLabel = By.id("com.lcwaikiki.android:id/grandTotalLabelText");
    By getGrandTotalSum = By.id("com.lcwaikiki.android:id/grandTotalValueText");

    By goToPaymentPage = By.id("com.lcwaikiki.android:id/tv_go_checkout");

    // Methods
    public void checkCartPage() {
        Assert.assertTrue(elementHelperAndroid.getText(cartPageTitle).contains(myCartPage));
    }

    public void checkProductName() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemTitle),"ads");
    }

    public void checkProductCode() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemCode), "asd");
    }

    public void checkProductSizeLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(productSizeLabel), size);
    }

    public void checkProductSize() {
        Assert.assertEquals(elementHelperAndroid.getText(productSize), "asd");
    }

    public void checkProductColourLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(productColourLabel), colour);
    }

    public void checkProductColour() {
        Assert.assertEquals(elementHelperAndroid.getText(productColour),"asd");
    }

    public void checkItemCountLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(itemCountLabel), count);
    }

    public void checkItemCount() {
        Assert.assertEquals(elementHelperAndroid.getText(itemCount), "asd");
    }

    public void checkProductItemPrice() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemPrice), "asd");
    }

    public void checkOrderSummaryLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(orderSummaryLabel), orderSummary);
    }

}
