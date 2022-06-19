package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utils.DriverFactory;
import web.pagesWeb.HomePageWeb;

public class HomePageStepsWeb {

    HomePageWeb homePageWeb = new HomePageWeb(DriverFactory.getDriver());

    @When("Hover to \"KADIN\" Button")
    public void hoverWomanCategory(){
        homePageWeb.hoverWomanButton();
    }

    @And("Click to \"Bluz\" Button of \"GİYİM\" Category")
    public void clickBlouseCategory(){
        homePageWeb.clickBlouseButton();
    }

    @And("Click to \"Siyah\" Button of \"Renk\" Category")
    public void clickBlousewCategory(){
        try {
            Thread.sleep(4553);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePageWeb.clickBlouseButton();
    }
}
