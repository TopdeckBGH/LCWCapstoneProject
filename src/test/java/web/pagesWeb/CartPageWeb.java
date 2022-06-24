package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverFactory;
import utils.ElementHelper;

public class CartPageWeb {

    public CartPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    SearchResultPageWeb searchResultPageWeb = new SearchResultPageWeb(DriverFactory.getDriver());

    // Attributes
    String quantityAttribute = "data-quantity";

    // Strings
    String itemSize = "M";
    String itemCount = "1";
    String orderSummary = "SİPARİŞ ÖZETİ";
    String totalSum = "Ürün Toplam";
    String subTotalSum = "Ara Toplam";
    String shipmentFee = "Kargo Ücreti";
    String grandTotal = "GENEL TOPLAM";

    // Elements
//region myCart
    By productItemTitleLabel = By.cssSelector(".rd-cart-item-title");
    By productItemSize = By.cssSelector(".rd-cart-item-size strong");
    By productItemCount = By.cssSelector("div.option-quantity input");
    By orderSummaryLabel = By.cssSelector("h1.mb-15");
//endregion

    //region priceInfoArea
    By goToPaymentStepButton = By.cssSelector("div.price-info-area [data-tracking-label=\"Siparişi Tamamla\"]");
    By productTotalSumLabel = By.xpath(priceInfoAreaLabelHelper(totalSum));
    By productTotalSum = By.xpath(priceInfoAreaSumHelper(totalSum));
    By productSubTotalSumLabel = By.xpath(priceInfoAreaLabelHelper(subTotalSum));
    By productSubTotalSum = By.xpath(priceInfoAreaSumHelper(subTotalSum));
    By shipmentFeeLabel = By.xpath(priceInfoAreaLabelHelper(shipmentFee));
    By shipmentFeeSum = By.xpath(priceInfoAreaSumHelper(shipmentFee));
    By grandTotalSumLabel = By.xpath(priceInfoAreaLabelHelper(grandTotal));
    By grandTotalSum = By.xpath(priceInfoAreaSumHelper(grandTotal));
//endregion


    // Methods

    /**
     * @param priceInfo
     * @return
     */
    public String priceInfoAreaLabelHelper(String priceInfo) {
        return "//*[@class='price-info-area']/* //span[@class='pull-left' and contains(., '" + priceInfo + "')]";
    }

    /**
     * @param priceInfo
     * @return
     */
    public String priceInfoAreaSumHelper(String priceInfo) {
        return priceInfoAreaLabelHelper(priceInfo) + "//following-sibling::span";
    }

    public void checkProductItemTitle() {
        Assert.assertTrue(ProductPageWeb.productTitle.contains(elementHelper.getText(productItemTitleLabel)));
    }

    public void checkProductItemSize() {
        Assert.assertEquals(elementHelper.getText(productItemSize), itemSize);
    }

    public void checkProductItemCount() {
        Assert.assertEquals(elementHelper.getAttribute(productItemCount, quantityAttribute), itemCount);
    }

    public void clickGoToPaymentPageButton() {
        elementHelper.click(goToPaymentStepButton);
    }

    public void checkOrderSummary() {
        Assert.assertEquals(elementHelper.getText(orderSummaryLabel), orderSummary);
    }

    public void checkProductTotalSumLabel() {
        Assert.assertEquals(elementHelper.getText(productTotalSumLabel), SearchResultPageWeb.price);
    }

    public void checkProductTotalSum() {
        Assert.assertEquals(elementHelper.getText(productTotalSum),  SearchResultPageWeb.price);
    }

    public void checkSubTotalSumLabel() {
        Assert.assertEquals(elementHelper.getText(productSubTotalSumLabel),  SearchResultPageWeb.price);

    }

    public void checkSubTotalSum() {
        Assert.assertEquals(elementHelper.getText(productSubTotalSum), subTotalSum);
    }

    public void checkShipmentFeeLabel() {
        Assert.assertEquals(elementHelper.getText(shipmentFeeLabel), shipmentFee);
    }

    public void checkShipmentFee() {
        Assert.assertEquals(elementHelper.getText(shipmentFeeSum), shipmentFee);
    }

    public void checkGrandTotalSumLabel() {
        Assert.assertEquals(elementHelper.getText(grandTotalSumLabel), grandTotal);
    }

    public void checkGrandTotalSum() {
        Assert.assertEquals(elementHelper.getText(grandTotalSum), grandTotal);
    }
}
