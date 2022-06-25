package android.stepDefinitionsAndroid;

import android.pagesAndroid.FilterPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class FilterStepsAndroid {

    FilterPageAndroid filterPageAndroid = new FilterPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Filter Page")
    public void assertFilterPage() {
        filterPageAndroid.checkFilterLabel();
    }

    @When("Tap on \"Renk\" Button")
    public void tapColourButton() {
        filterPageAndroid.clickColourButton();
    }

    @And("Tap on \"SONUÇLARI LİSTELE\" Button")
    public void tapListResultsButton() {
        filterPageAndroid.clickListerFilterResultsButton();
    }
}
