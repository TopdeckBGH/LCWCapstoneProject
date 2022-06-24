package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webUtils.DriverFactoryWeb;
import utils.webUtils.ElementHelperAndroid;

public class ProductPageWeb {

    public ProductPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelperAndroid(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;

    SearchResultPageWeb searchResultPageWeb = new SearchResultPageWeb(DriverFactoryWeb.getWebDriver());

    // Strings
    public static String productTitle;

    public int productOrder = 2;

    // Elements
    By mediumSizeButton = By.cssSelector("div.pt-5 div.option-size a[size=\"M\"]");
    By addToCartButton = By.cssSelector("[data-tracking-label=\"SepeteEkle\"]");
    By myCartButton = By.id("shopping-cart");
    By productTitleLabel = By.cssSelector("div.row div.product-title");
    By noSizeMAlert = By.cssSelector("div.product-detail a[size=\"M\"][data-stock=\"0\"]");
    By noSizeAlert = By.cssSelector("div.product-detail [data-stock=\"0\"]");


    // Methods
    public void clickMSizeButton() {
        //If one or more sizes are out of stock, the page prevents clicking on items except those sizes. That is why this methods is here.
        elementHelper.clickToLocation(0, 0);
        elementHelper.click(mediumSizeButton);
    }

    public void clickAddToCart() {
        productTitle = elementHelper.getText(productTitleLabel);
        elementHelper.click(addToCartButton);
    }

    public void clickMyCartButton() {
        elementHelper.click(myCartButton);
    }
}
