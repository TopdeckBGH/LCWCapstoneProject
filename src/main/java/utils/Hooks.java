package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utils.androidUtils.DriverFactoryAndroid;
import utils.webUtils.DriverFactoryWeb;

import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;

    By cartItem = By.cssSelector("div.col-md-12 h1");
    By orderSummaryInfo = By.cssSelector("p.ordersummaryinfo");

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

        }
        else if (applicationTypes == (ApplicationTypes.Web) &&
                ((driver.findElements(cartItem).size() > 0)  ||
                        driver.findElements(orderSummaryInfo).size() > 0)){
            driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");
            driver.findElement(By.cssSelector("i.fa-trash-o")).click();
            driver.findElement(By.cssSelector(".sc-delete")).click();
        }
        driver.quit();
    }
}
