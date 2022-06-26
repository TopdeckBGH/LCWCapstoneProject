package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.enums.PriceLabels;
import utils.webUtils.ElementHelperWeb;

import java.util.concurrent.TimeUnit;

public class SearchResultPageWeb {

    public SearchResultPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperWeb = new ElementHelperWeb(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperWeb elementHelperWeb;

    // Strings
    String blouseResults = "Bluz Modelleri";
    String blackColour = "Siyah";
    public static String price;

    // ints
    public static int productNumber = 1;

    // enums
    PriceLabels priceLabels;

    // Elements
    By blouseResultsLabel = By.cssSelector("div h1");
    By blackColourButton = By.xpath("//*[@class='color-filter-option__text' and contains(., 'Siyah')]");
    By blackColourFilterLabel = By.cssSelector("span.applied-filters__value");

    String searchProducts = "//*[contains(@class, \"product-card product-card--one-of-\")]";
    String oldPriceLabelPart = "//*[contains(@class, 'product-price__old-price')]";
    String discountedPriceLabelPart = "//*[contains(@class, 'product-price__old-price')]";
    String cartPriceLabelPart = "//span[contains(@class, 'product-price__cart-price product-price__cart-price--bigger')]";
    String noDiscountLabelPart = "//span[contains(@class, 'product-price__price product-price__price--only')]";



    // Methods
    public By elementUpdater(PriceLabels priceLabels, int productNumber)  {
        switch (priceLabels) {
            case Element:
                return By.xpath(searchProducts + "[" + productNumber + "]");
            case OldPrice:
                return By.xpath(searchProducts + "[" + productNumber + "]" + oldPriceLabelPart);
            case DiscountedPrice:
                return By.xpath(searchProducts + "[" + productNumber + "]" + discountedPriceLabelPart);
            case CartPrice:
                return By.xpath(searchProducts + "[" + productNumber + "]"  + cartPriceLabelPart);
            case NoDiscountPrice:
                return By.xpath(searchProducts + "[" + productNumber + "]" + noDiscountLabelPart);
            default:
                return null;
        }
    }

    public String getDiscountTypeAndValue() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (elementHelperWeb.assertElementIsVisible(elementUpdater(PriceLabels.OldPrice, productNumber)) && elementHelperWeb.assertElementIsVisible(elementUpdater(PriceLabels.CartPrice, productNumber))){
            priceLabels = PriceLabels.CartPrice;
            return price = elementHelperWeb.getText((elementUpdater(PriceLabels.CartPrice, productNumber)));
        }
        else if ((elementHelperWeb.assertElementIsVisible(elementUpdater(PriceLabels.OldPrice, productNumber))) && (!elementHelperWeb.assertElementIsVisible(elementUpdater(PriceLabels.CartPrice, productNumber)))){
            priceLabels = PriceLabels.DiscountedPrice;
            return price = elementHelperWeb.getText(elementUpdater(PriceLabels.DiscountedPrice, productNumber));
        }
        else {
            priceLabels = PriceLabels.NoDiscountPrice;
            return price = elementHelperWeb.getText(elementUpdater(PriceLabels.NoDiscountPrice, productNumber));
        }
    }

    public void checkBlouseResultsLabel(){
        Assert.assertEquals(elementHelperWeb.getText(blouseResultsLabel), blouseResults);
    }

    public void checkFilterColourBlack(){
        Assert.assertEquals(elementHelperWeb.getText(blackColourFilterLabel), blackColour);
    }

    public void clickBlackColour(){
        elementHelperWeb.click(blackColourButton);
    }

    public void clickFirstProduct() {
        getDiscountTypeAndValue();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementHelperWeb.click(elementUpdater(PriceLabels.Element, productNumber));
    }



}
