package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;

public class PaymentPageAndroid {

    public PaymentPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;

    // Strings
    String deliveryType = "Teslimat Türü";
    String summary = "SIPARIŞ ÖZETI";
    String productTotal = "Ürün Toplam";
    String subTotal = "Ara Toplam";
    String shipmentPrice = "Kargo Ücreti";
    String grandTotal = "GENEL TOPLAM";

    // Elements
    By paymentPageTitle = By.xpath("//android.widget.TextView[@text='Teslimat Türü']");
    By upArrowButton = By.id("com.lcwaikiki.android:id/checkoutSummaryArrow");
    By orderSummary = By.id("com.lcwaikiki.android:id/orderSummaryText");
    By productTotalSumLabel = By.id("com.lcwaikiki.android:id/totalLabelText");
    By productTotalSum = By.id("com.lcwaikiki.android:id/totalValueText");
    By subTotalSumLabel = By.id("com.lcwaikiki.android:id/subtotalLabelText");
    By subTotalSum = By.id("com.lcwaikiki.android:id/subtotalValueText");
    By shipmentFeeLabel = By.id("com.lcwaikiki.android:id/shippingLabelText");
    By shipmentFee = By.id("com.lcwaikiki.android:id/shippingValueText");
    By grandTotalSumLabel = By.id("com.lcwaikiki.android:id/grandTotalLabelText");
    By grandTotalSum = By.id("com.lcwaikiki.android:id/grandTotalValueText");

    // Methods
    public void checkPaymentPage() {
        Assert.assertEquals(elementHelperAndroid.getText(paymentPageTitle), deliveryType);
    }

    public void clickUpArrowButton() {
        elementHelperAndroid.click(upArrowButton);
    }

    public void checkOrderSummary () {
        Assert.assertEquals(elementHelperAndroid.getText(orderSummary), summary);
    }

    public void checkProductTotalSumLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(productTotalSumLabel), productTotal);
    }

    public void checkProductTotalSum() {
        Assert.assertEquals(elementHelperAndroid.getText(productTotalSum), SearchResultsPageAndroid.price);
    }

    public void checkSubTotalSumLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(subTotalSumLabel), subTotal);
    }

    public void checkSubTotalSum() {
        Assert.assertEquals(elementHelperAndroid.getText(subTotalSum), SearchResultsPageAndroid.price);
    }

    public void checkShipmentFeeLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(shipmentFeeLabel), shipmentPrice);
    }

    public void checkShipmentFee() {
        Assert.assertEquals(elementHelperAndroid.getText(shipmentFee), CartPageAndroid.shipmentPrice);
    }

    public void checkGrandTotalSum() {
        Assert.assertEquals(elementHelperAndroid.getText(grandTotalSumLabel), grandTotal);
    }

    public void checkGrandTotal() {
        Assert.assertEquals(elementHelperAndroid.getText(grandTotalSum), SearchResultsPageAndroid.price);
    }


}
