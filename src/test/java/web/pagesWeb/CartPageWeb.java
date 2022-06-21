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
    By productItemTitleLabel = By.cssSelector(".rd-cart-item-title");
    By productItemSize = By.cssSelector(".rd-cart-item-size strong");
    By productItemCount = By.cssSelector("div.option-quantity input");
    By goToPaymentStepButton = By.cssSelector("div.price-info-area [data-tracking-label=\"Siparişi Tamamla\"]");
    By deleteProductButton = By.cssSelector("i.fa-trash-o");

    // Attributes
    String quantityAttribute = "data-quantity";

    // Strings
    String itemSize = "M";
    String itemCount = "1";

    // Methods
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


}
