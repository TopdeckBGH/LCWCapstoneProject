package web.stepDefinitionsWeb;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.SearchResultPageWeb;

public class SearchStepsWeb {

    SearchResultPageWeb searchResultPageWeb = new SearchResultPageWeb(DriverFactoryWeb.getWebDriver());

    @Then("Check Blouse Results Label")
    public void assertBlouseResultsLabel() {
        searchResultPageWeb.checkBlouseResultsLabel();
    }

    @When("Click to \"Siyah\" Button of \"Renk\" Category")
    public void clickBlackColourCheckbox() {
        searchResultPageWeb.clickBlackColour();
    }

    @Then("Check Black Filter Colour Label")
    public void assertBlackFilterColourLabel() {
        searchResultPageWeb.checkFilterColourBlack();
    }

    @When("Click to the First Product")
    public void clickFirstProductButton() {
        searchResultPageWeb.clickFirstProduct();
    }
}
