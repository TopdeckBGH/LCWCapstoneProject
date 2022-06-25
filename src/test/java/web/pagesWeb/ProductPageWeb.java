package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webUtils.DriverFactoryWeb;
import utils.webUtils.ElementHelperWeb;

public class ProductPageWeb {

    public ProductPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperWeb = new ElementHelperWeb(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperWeb elementHelperWeb;

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
    By noMOptionAlert = By.cssSelector("div.product-detail a[size=\"M\"]");
    By noSizeAlert = By.cssSelector("div.top.evam-first-screen-click");


    // Methods
    public void clickMSizeButton() {
        if (elementHelperWeb.assertElementIsVisible(noSizeAlert)) {
            elementHelperWeb.clickToLocation(0, 0);
        }
        while (elementHelperWeb.assertElementIsVisible(noSizeMAlert)) {
            driver.navigate().back();
            SearchResultPageWeb.productNumber++;
            searchResultPageWeb.clickFirstProduct();
        }
        elementHelperWeb.click(mediumSizeButton);
    }

    public void clickAddToCart() {
        productTitle = elementHelperWeb.getText(productTitleLabel);
        elementHelperWeb.click(addToCartButton);
    }

    public void clickMyCartButton() {
        elementHelperWeb.click(myCartButton);
    }
}
