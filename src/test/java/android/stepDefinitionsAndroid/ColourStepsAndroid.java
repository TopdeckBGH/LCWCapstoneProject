package android.stepDefinitionsAndroid;

import android.pagesAndroid.ColourPageAndroid;
import io.cucumber.java.en.Then;
import utils.androidUtils.DriverFactoryAndroid;

public class ColourStepsAndroid {

    ColourPageAndroid colourPageAndroid = new ColourPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Colour Filter Page")
    public void assertColourFilterPage() {
        colourPageAndroid.checkColourFilterLabel();
    }
}
