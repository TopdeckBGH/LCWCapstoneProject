package web.pagesWeb;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.DriverFactoryWeb;
import utils.webUtils.ElementHelperWeb;

public class PaymentPageWeb {

    public PaymentPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperWeb = new ElementHelperWeb(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperWeb elementHelperWeb;

    // Strings
    String productTotal = "ÜRÜN TOPLAM";
    String subTotal = "ARA TOPLAM";
    String shipment = "KARGO ÜCRETİ";
    String grandTotal = "GENEL TOPLAM";

    // Elements
    By productTotalSumLabel = By.cssSelector("p.total :first-child");
    By productTotalSum = By.cssSelector("p.total span[id]");
    By discountsLabel = By.cssSelector("p.OrderSummaryDiscount strong");
    By discounts = By.id("spanShoppingCartDiscounts");
    By subTotalSumLabel = By.xpath("//p[@class=\"subtotal\"][1]");
    By subTotalSum = By.cssSelector("p.subtotal span[id=\"spanShoppingCartSubtotal\"]");
    By shipmentFeeLabel = By.cssSelector("p.price strong");
    By shipmentFee = By.cssSelector("span.spanShoppingCartShippingPrice");
    By grandTotalSumLabel = By.cssSelector("p.grandtotal strong");
    By grandTotalSum =  By.cssSelector("span[id=\"spanShoppingGrandTotal\"]");

    // Methods
    public void checkProductTotalSumLabel() {
        Assert.assertEquals(elementHelperWeb.getText(productTotalSumLabel), productTotal );
    }

    public void checkProductTotalSum() {
        Assert.assertEquals(elementHelperWeb.getText(productTotalSum), SearchResultPageWeb.price);
    }

    public void checkSubTotalSumLabel(){
        Assert.assertTrue(elementHelperWeb.getText(subTotalSumLabel).contains(subTotal));
    }

    public void checkSubTotalSum() {
        Assert.assertEquals(elementHelperWeb.getText(subTotalSum), SearchResultPageWeb.price);
    }

    public void checkShipmentFeeLabel() {
        Assert.assertTrue(elementHelperWeb.getText(shipmentFeeLabel).contains(shipment));
    }

    public void checkShipmentFee() {
        Assert.assertEquals(elementHelperWeb.getText(shipmentFee), CartPageWeb.shipment);
    }

    public void checkGrandTotalSumLabel() {
        Assert.assertTrue(elementHelperWeb.getText(grandTotalSumLabel).contains(grandTotal));
    }

    public void checkGrandTotalSum() {
        Assert.assertEquals(elementHelperWeb.getText(grandTotalSum), SearchResultPageWeb.price);
    }
}
