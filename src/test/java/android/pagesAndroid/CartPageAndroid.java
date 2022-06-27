package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
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

//region Info
    // Strings
    String myCartPage = "Sepetim";
    String size = "Beden:";
    String colour = "Renk:";
    String count = "Adet:";
    String orderSummary = "SİPARİŞ ÖZETİ";
    String blackColour = "Siyah";
    String productCount = "1";
    String itemSize = "M";


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

    // Methods
    public void checkCartPage() {
        Assert.assertTrue(elementHelperAndroid.getText(cartPageTitle).contains(myCartPage));
    }

    public void checkProductName() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemTitle), ProductPageAndroid.productItemTitle);
    }

    public void checkProductCode() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemCode), ProductPageAndroid.productItemCode);
    }

    public void checkProductSizeLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(productSizeLabel), size);
    }

    public void checkProductSize() {
        Assert.assertEquals(elementHelperAndroid.getText(productSize), itemSize);
    }

    public void checkProductColourLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(productColourLabel), colour);
    }

    public void checkProductColour() {
        Assert.assertTrue(elementHelperAndroid.getText(productColour).contains(blackColour));
    }

    public void checkItemCountLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(itemCountLabel), count);
    }

    public void checkItemCount() {
        Assert.assertEquals(elementHelperAndroid.getText(itemCount), productCount);
    }

    public void checkProductItemPrice() {
        Assert.assertEquals(elementHelperAndroid.getText(productItemPrice), SearchResultsPageAndroid.price);
    }
//endregion

//region Summary
    // Strings
    String productTotal = "Ürün Toplam";
    String subTotal = "Ara Toplam";
    String shipment = "Kargo Ücreti";
    String grandTotal = "GENEL TOPLAM";
    public static String shipmentPrice;

    // Elements
    By orderSummaryLabel = By.id("com.lcwaikiki.android:id/orderSummaryText");
    By upDownArrowButton = By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'com.lcwaikiki.android:id/rlSummar')][1]/android.widget.ImageView");
    By productTotalSumLabel = By.id("com.lcwaikiki.android:id/totalLabelText");
    By productTotalSum = By.id("com.lcwaikiki.android:id/totalValueText");
    By subTotalSumLabel = By.id("com.lcwaikiki.android:id/subtotalLabelText");
    By subTotalSum = By.id("com.lcwaikiki.android:id/subtotalValueText");
    By shipmentFeeLabel = By.id("com.lcwaikiki.android:id/shippingLabelText");
    By shipmentFee = By.id("com.lcwaikiki.android:id/shippingValueText");
    By grandTotalSumLabel = By.id("com.lcwaikiki.android:id/grandTotalLabelText");
    By grandTotalSum = By.id("com.lcwaikiki.android:id/grandTotalValueText");
    By goToPaymentPage = By.id("com.lcwaikiki.android:id/tv_go_checkout");

    // Methods
    public void checkOrderSummaryLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(orderSummaryLabel), orderSummary);
    }

    public void clickOptionsButton() {
        elementHelperAndroid.click(upDownArrowButton);
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
        shipmentPrice = elementHelperAndroid.getText(shipmentFee);
        Assert.assertEquals(elementHelperAndroid.getText(shipmentFeeLabel), shipment);
    }

    public void checkGrandTotalSumLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(grandTotalSumLabel), grandTotal);
    }

    public void checkGrandTotalSum() {
        Assert.assertEquals(elementHelperAndroid.getText(grandTotalSum), SearchResultsPageAndroid.price);
    }
    public void clickGoToPaymentPageButton() {
        elementHelperAndroid.getText(goToPaymentPage);
    }
//endregion
}
