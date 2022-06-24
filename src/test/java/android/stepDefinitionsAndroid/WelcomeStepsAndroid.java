package android.stepDefinitionsAndroid;

import android.pagesAndroid.WelcomePageAndroid;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class WelcomeStepsAndroid {

    WelcomePageAndroid welcomePageAndroid = new WelcomePageAndroid(DriverFactoryAndroid.getAppDriver());

    @When("Tap on \"Kategoriler\" Button")
    public void tapCategoriesButton() {
        welcomePageAndroid.clickCategoriesButton();
    }
}
