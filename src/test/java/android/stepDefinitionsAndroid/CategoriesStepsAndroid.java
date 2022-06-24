package android.stepDefinitionsAndroid;

import android.pagesAndroid.CategoriesPageAndroid;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class CategoriesStepsAndroid {

    CategoriesPageAndroid categoriesPageAndroid = new CategoriesPageAndroid(DriverFactory.getAppDriver());

    @Then("Check Categories Page")
    public void assertCategoriesPage() {
        categoriesPageAndroid.checkCategoriesLabel();
    }
    @When("Tap on \"Giyim\" Button")
    public void tapClothingButton() {
        categoriesPageAndroid.clickClothingButton();
    }

    @Then("Tap on \"Bluz\" Button")
    public void tapBlouseButton() {
        categoriesPageAndroid.clickBlouseButton();
    }

}
