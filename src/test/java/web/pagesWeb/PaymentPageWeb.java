package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    // Elements
    By productTotalSumLabel = By.cssSelector("p.total :first-child");
    By productTotalSum = By.cssSelector("p.total :last-child");
    By discountsLabel = By.cssSelector("p.OrderSummaryDiscount strong");
    By discounts = By.id("spanShoppingCartDiscounts");
    By subTotalSumLabel = By.xpath("//p[@class='subtotal' and contains(., 'ARA')] ");
    By subTotalSum = By.cssSelector("p.subtotal span[id=\"spanShoppingCartSubtotal\"]");
    By shipmentFeeLabel = By.cssSelector("p.price strong");
    By shipmentFee = By.cssSelector("span.spanShoppingCartShippingPrice");
    By grandTotalSumLabel = By.cssSelector("p.grandtotal strong");
    By grandTotalSum =  By.cssSelector("span[id=\"spanShoppingGrandTotal\"]");
}
