package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementHelper;

public class SearchResultPageWeb {

    public SearchResultPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Elements
    By blouseResultsLabel = By.cssSelector("div h1");
    By blackColourButton = By.xpath("//*[@class='color-filter-option__text' and contains(., 'Siyah')]");
    By blackColourFilterLabel = By.cssSelector("span.applied-filters__value");
    By firstSearchedProduct = By.cssSelector("div.product-card:nth-child(3)");

    // Strings
    String blouseResults = "Bluz Modelleri";
    String blackColour = "Siyah";

    // Methods
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
        elementHelper.click(firstSearchedProduct);
    }

}
