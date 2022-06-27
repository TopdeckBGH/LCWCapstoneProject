package android.stepDefinitionsAndroid;

import android.pagesAndroid.PaymentPageAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.androidUtils.DriverFactoryAndroid;

public class PaymentStepsAndroid {

    PaymentPageAndroid paymentPageAndroid = new PaymentPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Then("Check Payment Page")
    public void assertPaymentPage() {
        paymentPageAndroid.checkPaymentPage();
    }

    @When("Tap on the Up Arrow Button Payment Page")
    public void tapUpArrowButton() {
        paymentPageAndroid.clickUpArrowButton();
    }

    @Then("Check \"Ürün Toplam\" Label Payment Page Android")
    public void assertProductTotalSumLabel() {
        paymentPageAndroid.checkProductTotalSumLabel();
    }

    @And("Check Product Total Sum Payment Page Android")
    public void assertProductTotalSumL() {
        paymentPageAndroid.checkProductTotalSum();
    }

    @And("Check \"Ara Toplam\" Label Payment Page Android")
    public void assertSubTotalSumLabel() {
        paymentPageAndroid.checkSubTotalSumLabel();
    }

    @And("Check Subtotal Sum Payment Page Android")
    public void assertSubTotalSum() {
        paymentPageAndroid.checkSubTotalSum();
    }

    @And("Check \"Kargo Ücreti\" Label Payment Page Android")
    public void assertShipmentFeeLabel() {
        paymentPageAndroid.checkShipmentFeeLabel();
    }

    @And("Check Shipment Fee Sum Payment Page Android")
    public void assertShipmentFee() {
        paymentPageAndroid.checkShipmentFee();
    }

    @And("Check \"GENEL TOPLAM\" Label Payment Page Android")
    public void assertGrandTotalSumLabel() {
        paymentPageAndroid.checkGrandTotalSum();
    }

    @And("Check Grand Total Sum Payment Page Android")
    public void assertGrandTotalSum() {
        paymentPageAndroid.checkGrandTotal();
    }

}
