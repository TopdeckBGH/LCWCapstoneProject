package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import utils.androidUtils.DriverFactoryAndroid;
import utils.enums.ApplicationTypes;
import utils.webUtils.DriverFactoryWeb;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;

    // Elements
    By cartItem = By.cssSelector("div.col-md-12 h1");
    By orderSummaryInfo = By.cssSelector("p.ordersummaryinfo");
    By cartItemAndroid = By.id("com.lcwaikiki.android:id/notificationsBadgeTextView");
    By cartButton = By.xpath("//android.widget.TextView[@text='Sepetim']");
    By trashBinButton = By.id("com.lcwaikiki.android:id/basketClearLayout");
    By deleteButton = By.id("com.lcwaikiki.android:id/buttonNegative");
    By paperBagImage = By.id("com.lcwaikiki.android:id/emptyBasketImage");
    By emptyCart = By.cssSelector("p.cart-empty-title");
    By deliveryType = By.id("com.lcwaikiki.android:id/checkoutTitleText");

    static ApplicationTypes applicationTypes;

    @Before
    public void before() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initProperties();
        if (browser.equals("Android")){
            applicationTypes = ApplicationTypes.Android;
            driver = DriverFactoryAndroid.initAppDriver(browser);
        }
        else if (browser.equals("Chrome")){
            applicationTypes = ApplicationTypes.Web;
            driver = DriverFactoryWeb.initWebDriver(browser);
        }
    }

    @After
    public void after() {
        if(applicationTypes == ApplicationTypes.Android){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if (driver.findElements(deliveryType).size() > 0){
                driver.navigate().back();
            }
            else if(driver.findElements(cartItemAndroid).size() > 0) {

            }
            else {
                while (driver.findElements(cartItemAndroid).size() == 0 &&
                        driver.findElements(cartButton).size() == 0)
                {
                    driver.navigate().back();
                }
                driver.findElement(cartButton).click();
            }
            driver.findElement(trashBinButton).click();
            driver.findElement(deleteButton).click();
            driver.findElement(paperBagImage);
        }
        else if (applicationTypes == (ApplicationTypes.Web) &&
                ((driver.findElements(cartItem).size() > 0)  ||
                  driver.findElements(orderSummaryInfo).size() > 0)){
                      driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");
                      driver.findElement(By.cssSelector("i.fa-trash-o")).click();
                      driver.findElement(By.cssSelector(".sc-delete")).click();
                      driver.findElement(emptyCart);
        }
        driver.quit();
    }
}
