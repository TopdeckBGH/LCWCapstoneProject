package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.ElementHelperAndroid;

public class SearchResultPageWeb {

    public SearchResultPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelperAndroid(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;

    // Strings
    String blouseResults = "Bluz Modelleri";
    String blackColour = "Siyah";
    String followingSiblingSpan = "\"//following-sibling::span";
//    public static String noDiscountPrice;
//    public static String discountedPrice;
//    public static String cartDiscountedPrice;
    public static String price;

    // Elements
    By blouseResultsLabel = By.cssSelector("div h1");
    By blackColourButton = By.xpath("//*[@class='color-filter-option__text' and contains(., 'Siyah')]");
    By blackColourFilterLabel = By.cssSelector("span.applied-filters__value");
    //By firstSearchedProduct = By.cssSelector("div.product-card:nth-child(3)");
    By thirdSearchedProduct = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [3]");
    By productOldPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [3] //*[contains(@class, 'product-price__old-price')]");
    By productDiscountedPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [3] //*[contains(@class, 'product-price__old-price')]" + followingSiblingSpan);
    By productCartPriceLabel = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [3] //span[contains(@class, 'product-price__cart-price product-price__cart-price--bigger')]");
    By productPriceNoDiscount = By.xpath("//*[contains(@class, \"product-card product-card--one-of-\")] [3] //span[contains(@class, 'product-price__price product-price__price--only product-price__price--bigger')]");

    // Methods
    public String getDiscountTypeAndValue() {
       // if (elementHelper.findElements(productOldPriceLabel) != null & elementHelper.findElements(productCartPriceLabel) == null){
        //if ((elementHelper.findElements(productOldPriceLabel).size() > 0) & (elementHelper.findElements(productCartPriceLabel).size()) <= 0){
        //if (Assert.assertNull(elementHelper.findElement(productOldPriceLabel)) & Assert.assertNull(elementHelper.findElements(productCartPriceLabel)){
        if ((elementHelper.assertElementIsVisible(productOldPriceLabel)) && (!elementHelper.assertElementIsVisible(productCartPriceLabel))){
            return price = elementHelper.getText(productDiscountedPriceLabel);
        }
        else if (elementHelper.assertElementIsVisible(productOldPriceLabel) & elementHelper.assertElementIsVisible(productCartPriceLabel)){
            return price = elementHelper.getText((productCartPriceLabel));
        }
        else {
            return price = elementHelper.getText(productPriceNoDiscount);
        }
    }

    public void checkBlouseResultsLabel(){
        Assert.assertEquals(elementHelper.getText(blouseResultsLabel), blouseResults);
    }

    public void checkFilterColourBlack(){
        Assert.assertEquals(elementHelper.getText(blackColourFilterLabel), blackColour);
    }

    public void clickBlackColour(){
        elementHelper.click(blackColourButton);
    }

    public void clickFirstProduct() {
        getDiscountTypeAndValue();
        elementHelper.click(thirdSearchedProduct);
    }


}
