package android.stepDefinitionsAndroid;

import android.pagesAndroid.ColourPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class ColourStepsAndroid {

    ColourPageAndroid colourPageAndroid = new ColourPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Colour Filter Page")
    public void assertColourFilterPage() {
        colourPageAndroid.checkColourFilterLabel();
    }

    @When("Tap on \"Siyah\" Button")
    public void tapBlackColourFilterButton() {
        colourPageAndroid.clickBlackColourFilterButton();
    }

    @And("Tap on \"UYGULA\" Button")
    public void tapApplyButton(){
        colourPageAndroid.clickApplyButton();
    }

}
