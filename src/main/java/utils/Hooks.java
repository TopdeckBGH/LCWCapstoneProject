package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;

    @Before
    public void before() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initProperties();
        driver = DriverFactory.initDriver(browser);
    }

    @After
    public void after() {
        driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");
        driver.findElement(By.cssSelector("i.fa-trash-o")).click();
        driver.findElement(By.cssSelector(".sc-delete")).click();
        driver.quit();
    }
}
