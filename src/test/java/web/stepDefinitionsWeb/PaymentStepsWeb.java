package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.PaymentPageWeb;

public class PaymentStepsWeb {

    PaymentPageWeb paymentPageWeb = new PaymentPageWeb(DriverFactoryWeb.getWebDriver());

    @Then("Check \"Ürün Toplam\" Label Payment Page")
    public void assertProductTotalLabel() {
        paymentPageWeb.checkProductTotalSumLabel();
    }

    @And("Check Product Total Sum Payment Page")
    public void assertProductTotalSum(){
        paymentPageWeb.checkProductTotalSum();
    }
//    @And("Check DiscountsLabel Payment Page")
//    @And("Check Discounts Payment Page")
    @And("Check \"Ara Toplam\" Label Payment Page")
    public void assertSubTotalSumLabel() {paymentPageWeb.checkSubTotalSumLabel();}

    @And("Check Subtotal Sum Payment Page")
    public void assertSubTotalSum() {
        paymentPageWeb.checkSubTotalSum();
    }

    @And("Check \"Kargo Ücreti\" Label Payment Page")
    public void assertShipmentFeeLabel() {
        paymentPageWeb.checkShipmentFeeLabel();
    }

    @And("Check Shipment Fee Sum Payment Page")
    public void assertShipmentFee() {
        paymentPageWeb.checkShipmentFee();
    }

    @And("Check \"GENEL TOPLAM\" Label Payment Page")
    public void assertGrandTotalSumLabel() {
        paymentPageWeb.checkGrandTotalSumLabel();
    }

    @And("Check Grand Total Sum Payment Page")
    public void assertGrandTotalSum() {
        paymentPageWeb.checkGrandTotalSum();
    }


}
