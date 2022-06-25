package android.stepDefinitionsAndroid;

import android.pagesAndroid.SearchResultsPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class SearchResultsStepsAndroid {

    SearchResultsPageAndroid searchResultsPageAndroid = new SearchResultsPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Blouse Products Page")
    public void assertBlouseProductsPage() {
        searchResultsPageAndroid.checkBlouseResultsLabel();
    }

    @When("Tap on \"Filtre\" Button")
    public void tapFilterButton() {
        searchResultsPageAndroid.clickFilterButton();
    }

    @And("Tap on on the First Product")
    public void tapFirstProductButton () {
        searchResultsPageAndroid.clickFirstProductButton();
    }
}
