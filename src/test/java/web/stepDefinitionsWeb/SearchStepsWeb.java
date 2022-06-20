package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import utils.DriverFactory;
import web.pagesWeb.SearchResultPageWeb;

public class SearchStepsWeb {

    SearchResultPageWeb searchResultPageWeb = new SearchResultPageWeb(DriverFactory.getDriver());

    @And("Click to \"Siyah\" Button of \"Renk\" Category")
    public void clickBlackColourCheckbox(){
        searchResultPageWeb.clickBlackColour();
    }

    @And("Click to the First Product")
    public void clickFirstProductButton(){
        searchResultPageWeb.clickFirstProduct();
    }
}
