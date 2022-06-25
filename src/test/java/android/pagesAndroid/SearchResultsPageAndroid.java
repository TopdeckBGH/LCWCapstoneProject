package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;

public class SearchResultsPageAndroid {

    public SearchResultsPageAndroid(AppiumDriver driver) {
        this.appiumDriver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(driver);
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;


    // Strings
    String blouseResults = "Bluz";


    // Elements
    By blouseResultsLabel = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By filterButton = By.id("com.lcwaikiki.android:id/filter_text");
    By firstProductButton = By.xpath("//*[contains(@class,\"RecyclerView\")][2]/*[contains(@class,\"android.view.ViewGroup\")][1]");

    // Methods
    public void checkBlouseResultsLabel() {
        Assert.assertEquals(elementHelperAndroid.getText(blouseResultsLabel), blouseResults);
    }

    public void clickFilterButton() {
        elementHelperAndroid.click(filterButton);
    }

    public void clickFirstProductButton() {
        elementHelperAndroid.click(firstProductButton);
    }
}
