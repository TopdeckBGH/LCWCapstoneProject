package android.stepDefinitionsAndroid;

import android.pagesAndroid.ProductPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class ProductStepsAndroid {

    ProductPageAndroid productPageAndroid = new ProductPageAndroid(DriverFactoryAndroid.getAppDriver());

    @And("Tap on the Up Arrow Button")
    public void tapUpArrowButton() {
        productPageAndroid.clickUpArrowButton();
    }

    @And("Tap on \"M\" Button of Beden Label")
    public void tapSizeMButton() {
        productPageAndroid.clickSizeMButton();
    }

    @Then("Check Item Name")
    public void assertItemName() {
        productPageAndroid.checkItemName();
    }
    @And("Check Item Price")
    public void assertItemPrice() {
        productPageAndroid.checkItemPrice();
    }

    @When("Tap on \"SEPETE EKLE\" Button")
    public void tapAddToCartButton() {
        productPageAndroid.clickAddToCartButton();
    }

    @And("Tap on \"Sepete Git\" Button")
    public void tapGoToCartButton() {
        productPageAndroid.clickGoToCartButton();
    }

}
