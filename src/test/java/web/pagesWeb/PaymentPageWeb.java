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

    CartPageWeb cartPageWeb = new CartPageWeb(DriverFactoryWeb.getWebDriver());

    // Strings
    String productTotal = "ÜRÜN TOPLAM";
    String subTotal = "ARA TOPLAM";
    String shipment = "KARGO ÜCRETİ";
    String grandTotal = "GENEL TOPLAM";

    // Elements
    By productTotalSumLabel = By.cssSelector("p.total :first-child");
    By productTotalSum = By.cssSelector("p.total :last-child");
    By discountsLabel = By.cssSelector("p.OrderSummaryDiscount strong");
    By discounts = By.id("spanShoppingCartDiscounts");
    By subTotalSumLabel = By.xpath("//p[@class='subtotal' and contains(., 'ARA')]");
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
        Assert.assertEquals(elementHelperWeb.getText(subTotalSumLabel), subTotal);
    }

    public void checkSubTotalSum() {
        Assert.assertEquals(elementHelperWeb.getText(subTotalSum), SearchResultPageWeb.price);
    }

    public void checkShipmentFeeLabel() {
        Assert.assertEquals(elementHelperWeb.getText(shipmentFeeLabel), shipment);
    }

    public void checkShipmentFee() {
        Assert.assertEquals(elementHelperWeb.getText(shipmentFee), "BEDAVA");
    }

    public void checkGrandTotalSumLabel() {
        Assert.assertEquals(elementHelperWeb.getText(grandTotalSumLabel), grandTotal);
    }

    public void checkGrandTotalSum() {
        Assert.assertEquals(elementHelperWeb.getText(grandTotalSum), SearchResultPageWeb.price);
    }
}
