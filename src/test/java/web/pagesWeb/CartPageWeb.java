package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    // Elements
//region myCart
    By productItemTitleLabel = By.cssSelector(".rd-cart-item-title");
    By productItemSize = By.cssSelector(".rd-cart-item-size strong");
    By productItemCount = By.cssSelector("div.option-quantity input");
    By orderSummaryLabel = By.cssSelector("h1.mb-15");
//endregion

//region priceInfoArea
    By goToPaymentStepButton = By.cssSelector("div.price-info-area [data-tracking-label=\"Siparişi Tamamla\"]");
    By productTotalSumLabel = By.xpath(priceInfoAreaLabelHelper("Ürün Toplam"));
    By productTotalSum = By.xpath(priceInfoAreaSumHelper("Ürün Toplam"));
    By productSubTotalSumLabel = By.xpath(priceInfoAreaLabelHelper("Ara Toplam"));
    By productSubTotalSum = By.xpath(priceInfoAreaSumHelper("Ara Toplam"));
    By shipmentFeeSumLabel = By.xpath(priceInfoAreaLabelHelper("Kargo Ücreti"));
    By shipmentFeeSum = By.xpath(priceInfoAreaSumHelper("Kargo Ücreti"));
    By grandTotalSumLabel = By.xpath(priceInfoAreaLabelHelper("GENEL TOPLAM"));
    By grandTotalSum = By.xpath(priceInfoAreaSumHelper("GENEL TOPLAM"));
//endregion

    // Attributes
    String quantityAttribute = "data-quantity";

    // Strings
    String itemSize = "M";
    String itemCount = "1";
    String orderSummary = "SİPARİŞ ÖZETİ";

    // Methods
    /**
     *
     * @param priceInfo
     * @return
     */
    public String priceInfoAreaLabelHelper(String priceInfo){
        return "//*[@class='price-info-area']/* //span[@class='pull-left' and contains(., '" + priceInfo + "')]";
    }

    /**
     *
     * @param priceInfo
     * @return
     */
    public String priceInfoAreaSumHelper(String priceInfo){
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

    public void checkOrderSummary(){
        Assert.assertEquals(elementHelper.getText(orderSummaryLabel), orderSummary);
    }


}
