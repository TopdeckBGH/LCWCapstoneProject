package android.stepDefinitionsAndroid;

import android.pagesAndroid.WelcomePageAndroid;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class WelcomeStepsAndroid {

    WelcomePageAndroid welcomePageAndroid = new WelcomePageAndroid(DriverFactory.getAppDriver());

    @When("Tap on \"Kategoriler\" Button")
    public void tapCategoriesButton() {
        welcomePageAndroid.clickCategoriesButton();
    }
}
