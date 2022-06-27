package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/web/featuresWeb"},
        glue = {"web/stepDefinitionsWeb", "utils"},
        tags = "@Web",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class WebRunner extends AbstractTestNGCucumberTests{
}

