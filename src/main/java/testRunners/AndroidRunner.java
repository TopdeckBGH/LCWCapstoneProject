package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/android/featuresAndroid"},
        glue = {"android/stepDefinitionsAndroid", "utils"},
        tags = "@Android",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class AndroidRunner extends AbstractTestNGCucumberTests{
}

