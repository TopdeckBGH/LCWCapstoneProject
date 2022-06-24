package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.CartPageWeb;

public class CartStepsWeb {

    CartPageWeb cartPageWeb = new CartPageWeb(DriverFactoryWeb.getWebDriver());

    @Then("Check \"Title\" Label of the Product")
    public void assertProductItemTitle() {
        cartPageWeb.checkProductItemTitle();
    }

    @And("Check \"Size\" Label of the Product")
    public void assertProductItemSize() {
        cartPageWeb.checkProductItemSize();
    }

    @And("Check Product Count")
    public void assertProductCount() {
        cartPageWeb.checkProductItemCount();
    }

    @And("Check Order Summary Label")
    public void assertOrderSummaryLabel(){
        cartPageWeb.checkOrderSummary();
    }

    @And("Check \"Ürün Toplam\" Label")
    public void assertProductTotalSumLabel() {
        cartPageWeb.checkProductTotalSumLabel();
    }

    @And("Check Product Total Sum")
    public void assertProductTotalSum() {
        cartPageWeb.checkProductTotalSum();
    }

    @And("Check \"Ara Toplam\" Label")
    public void assertSubTotalLabel() {
        cartPageWeb.checkSubTotalSumLabel();
    }

    @And("Check Subtotal Sum")
    public void assertSubTotal() {
        cartPageWeb.checkSubTotalSum();
    }
    @And("Check \"Kargo Ücreti\" Label")
    public void assertShipmentFeeLabel() {
        cartPageWeb.checkShipmentFeeLabel();
    }

    @And("Check Shipment Fee Sum")
    public void assertShipmentFee() {
        cartPageWeb.checkShipmentFee();
    }

    @And("Check \"GENEL TOPLAM\" Label")
    public void assertGrandTotalLabel() {
        cartPageWeb.checkGrandTotalSumLabel();
    }

    @And("Check Grand Total Sum")
    public void assertGrandTotal() {
        cartPageWeb.checkGrandTotalSum();
    }

    @When("Click to \"ÖDEME ADIMINA GEÇ\" Button")
    public void clickGoToPaymentButton() {
        cartPageWeb.clickGoToPaymentPageButton();
    }

}
