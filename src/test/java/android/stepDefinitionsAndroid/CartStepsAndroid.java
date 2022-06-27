package android.stepDefinitionsAndroid;

import android.pagesAndroid.CartPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.androidUtils.DriverFactoryAndroid;

public class CartStepsAndroid {

    CartPageAndroid cartPageAndroid = new CartPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Cart Page")
    public void assertCartPage() {
        cartPageAndroid.checkCartPage();
    }

    @And("Check Product Name Android")
    public void assertProductName() {
        cartPageAndroid.checkProductName();
    }

    @And("Check Product Code Android")
    public void assertProductCode() {
        cartPageAndroid.checkProductCode();
    }

    @And("Check Product Size Label Android")
    public void assertProductSizeLabel() {
        cartPageAndroid.checkProductSizeLabel();
    }

    @And("Check Product Size Android")
    public void assertProductSize() {
        cartPageAndroid.checkProductSize();
    }

    @And("Check Product Colour Label Android")
    public void assertProductColourLabel() {
        cartPageAndroid.checkProductColourLabel();
    }

    @And("Check Product Colour Android")
    public void assertProductColour() {
        cartPageAndroid.checkProductColour();
    }

    @And("Check Item Count Label Android")
    public void assertItemCountLabel() {
        cartPageAndroid.checkItemCountLabel();
    }

    @And("Check Item Count Android")
    public void assertItemCount() {
        cartPageAndroid.checkItemCount();
    }

    @And("Check Product Item Price Android")
    public void assertItemPrice() {
        cartPageAndroid.checkProductItemPrice();
    }

    @And("Check \"Sipariş Özeti\" Label")
    public void assertOrderSummaryLabel() {
        cartPageAndroid.checkOrderSummaryLabel();
    }

}
