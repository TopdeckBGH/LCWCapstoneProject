package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;
import web.pagesWeb.CartPageWeb;

public class CartStepsWeb {

    CartPageWeb cartPageWeb = new CartPageWeb(DriverFactory.getDriver());

    @Then("Check \"Title\" Label of the Product")
    public void assertProductItemTitle(){
        cartPageWeb.checkProductItemTitle();
    }

    @And("Check \"Size\" Label of the Product")
    public void assertProductItemSize(){
        cartPageWeb.checkProductItemSize();
    }

    @And("Check Product Count")
    public void assertProductCount() {
        cartPageWeb.checkProductItemCount();
    }

    @When("Click to \"ÖDEME ADIMINA GEÇ\" Button")
    public void clickGoToPaymentButton(){
        cartPageWeb.clickGoToPaymentPageButton();
    }

}
