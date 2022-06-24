package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utils.androidUtils.DriverFactoryAndroid;
import utils.webUtils.DriverFactoryWeb;

import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;

    @Before
    public void before() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initProperties();
        if (browser.equals("Android")){
            driver = DriverFactoryAndroid.initAppDriver(browser);
        }
        else if (browser.equals("Chrome")){
            driver = DriverFactoryWeb.initWebDriver(browser);
        }
    }

    @After
    public void after() {
//        driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");
//        driver.findElement(By.cssSelector("i.fa-trash-o")).click();
//        driver.findElement(By.cssSelector(".sc-delete")).click();
        driver.quit();
    }
}
