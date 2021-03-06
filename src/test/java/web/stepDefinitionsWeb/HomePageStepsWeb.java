package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.HomePageWeb;

public class HomePageStepsWeb {

    HomePageWeb homePageWeb = new HomePageWeb(DriverFactoryWeb.getWebDriver());

    @When("Hover to \"KADIN\" Button")
    public void hoverWomanCategory() {
        homePageWeb.hoverWomanButton();
    }

    @And("Click to \"Bluz\" Button of \"GİYİM\" Category")
    public void clickBlouseCategory() {
        homePageWeb.clickBlouseButton();
    }

}
