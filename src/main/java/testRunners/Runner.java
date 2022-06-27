package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import utils.webUtils.DriverFactoryWeb;

@CucumberOptions(
        features = {"src/test/java/android/featuresAndroid"},
        glue = {"android/stepDefinitionsAndroid", "utils"},
        tags = "@Android",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class Runner extends AbstractTestNGCucumberTests{
}

