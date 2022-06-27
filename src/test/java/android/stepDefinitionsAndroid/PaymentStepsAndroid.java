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

    }

    @When("Tap on the Up Arrow Button Payment Page")
    public void tapUpArrowButton() {

    }

    @Then("Check \"Ürün Toplam\" Label Payment Page Android")
    public void assertProductTotalSumLabel() {

    }

    @And("Check Product Total Sum Payment Page Android")
    public void assertProductTotalSumL() {

    }

    @And("Check \"Ara Toplam\" Label Payment Page Android")
    public void assertSubTotalSumLabel() {

    }

    @And("Check Subtotal Sum Payment Page Android")
    public void assertSubTotalSum() {

    }

    @And("Check \"Kargo Ücreti\" Label Payment Page Android")
    public void assertShipmentFeeLabel() {

    }

    @And("Check Shipment Fee Sum Payment Page Android")
    public void assertShipmentFee() {

    }

    @And("Check \"GENEL TOPLAM\" Label Payment Page Android")
    public void assertGrandTotalSumLabel() {

    }

    @And("Check Grand Total Sum Payment Page Android")
    public void assertGrandTotalSum() {

    }

}
