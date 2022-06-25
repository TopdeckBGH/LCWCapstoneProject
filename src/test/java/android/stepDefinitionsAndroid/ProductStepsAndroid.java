package android.stepDefinitionsAndroid;

import android.pagesAndroid.ProductPageAndroid;
import io.cucumber.java.en.And;
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

    @And("Tap on \"SEPETE EKLE\" Button")
    public void tapAddToCartButton() {
        productPageAndroid.clickAddToCartButton();
    }

    @And("Tap on \"Sepete Git\" Button")
    public void tapGoToCartButton() {
        productPageAndroid.clickGoToCartButton();
    }

}
