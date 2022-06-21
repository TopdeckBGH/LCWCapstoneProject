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

    ProductPageWeb productPageWeb = new ProductPageWeb(DriverFactory.getDriver());

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Elements
    By productItemTitleLabel = By.cssSelector(".rd-cart-item-title");
    By productItemCodeLabel = By.cssSelector("rd-cart-item-code");
    By productItemSize = By.cssSelector(".rd-cart-item-size strong");
    By productItemColour = By.cssSelector("rd-cart-item-color");
    By productItemCount = By.cssSelector("div.option-quantity input");

    // Attributes
    String quantityAttribute = "data-quantity";

    // Strings
    String itemSize = "M";
    String itemCount = "1";

    // Methods
    public void checkProductItemTitle() {
        //Assert.assertTrue(elementHelper.getText(productItemTitleLabel).contains(ProductPageWeb.productTitle));
        Assert.assertEquals(elementHelper.getText(productItemTitleLabel),"4");
    }

    public void checkProductItemCode() {
        Assert.assertEquals(elementHelper.getText(productItemCodeLabel) + " - " +
                elementHelper.getText(productItemColour), ProductPageWeb.productCode);
    }

    public void checkProductItemSize() {
        Assert.assertEquals(elementHelper.getText(productItemSize), itemSize);
    }

    public void checkProductItemCount() {
        Assert.assertEquals(elementHelper.getAttribute(productItemCount, quantityAttribute), itemCount);
    }

}
