package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.ElementHelperWeb;

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
    String followingSiblingSpan = "//following-sibling::span";
//    public static String noDiscountPrice;
//    public static String discountedPrice;
//    public static String cartDiscountedPrice;
    public static String price;

    // Elements
    By blouseResultsLabel = By.cssSelector("div h1");
    By blackColourButton = By.xpath("//*[@class='color-filter-option__text' and contains(., 'Siyah')]");
    By blackColourFilterLabel = By.cssSelector("span.applied-filters__value");
    By firstSearchedProduct = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [1]");
    By productOldPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [1] //*[contains(@class, 'product-price__old-price')]");
    By productDiscountedPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [1] //*[contains(@class, 'product-price__old-price')]" + followingSiblingSpan);
    By productCartPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [1] //span[contains(@class, 'product-price__cart-price product-price__cart-price--bigger')]");
    By productPriceNoDiscount = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [1] //span[contains(@class, 'product-price__price product-price__price--only')]");

    // Methods
    public String getDiscountTypeAndValue() {
        if (elementHelperWeb.assertElementIsVisible(productOldPriceLabel) && elementHelperWeb.assertElementIsVisible(productCartPriceLabel)){
            return price = elementHelperWeb.getText((productCartPriceLabel));
        }
        else if ((elementHelperWeb.assertElementIsVisible(productOldPriceLabel)) && (!elementHelperWeb.assertElementIsVisible(productCartPriceLabel))){
            return price = elementHelperWeb.getText(productDiscountedPriceLabel);
        }
        else {
            return price = elementHelperWeb.getText(productPriceNoDiscount);
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
        elementHelperWeb.click(firstSearchedProduct);
    }


}
