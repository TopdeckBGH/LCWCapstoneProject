package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

public class ProductPageWeb {

    public ProductPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;


    // Elements
    By mediumSizeButton = By.cssSelector("div.pt-5 div.option-size a[size=\"M\"]");
    By addToCartButton = By.cssSelector("[data-tracking-label=\"SepeteEkle\"]");
    By myCartButton = By.id("shopping-cart");

    By productCodeLabel = By.cssSelector("span.hidden-xs");
    By productTitleLabel = By.cssSelector("div.info-panel div.product-title");

    public static String productCode;
    public static String productTitle;

    // Methods
    public void clickMSizeButton() {
        //If one or more sizes are out of stock, the page prevents clicking on items except those sizes. That is why this methods is here.
        elementHelper.clickToLocation(0, 0);
        elementHelper.click(mediumSizeButton);
    }

    public void clickAddToCart() {
        productCode = elementHelper.getText(productCodeLabel);
        productTitle = elementHelper.getText(productTitleLabel);
        elementHelper.click(addToCartButton);
    }

    public void clickMyCartButton() {
        elementHelper.click(myCartButton);
    }
}
