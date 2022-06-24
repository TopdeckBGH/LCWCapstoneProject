package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/web/featuresWeb"},
        glue = {"android/stepDefinitionsAndroid", "utils"},
        tags = "@Android",
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class Runner extends AbstractTestNGCucumberTests{
    static WebDriver driver = DriverFactory.getWebDriver();

}

