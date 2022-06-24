package testRunners;

import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/web/featuresWeb"},
        glue = {"web/stepDefinitionsWeb", "utils"},
        tags = "@Web",
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class Runner extends AbstractTestNGCucumberTests{
    static WebDriver driver = DriverFactory.getDriver();

}

