package web.stepDefinitionsWeb;

import io.cucumber.java.en.And;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.ProductPageWeb;

public class ProductStepsWeb {

    ProductPageWeb productPageWeb = new ProductPageWeb(DriverFactoryWeb.getWebDriver());

    @And("Click to \"M\" Button of \"Beden\" Label")
    public void clickMediumSizeButton() {
        productPageWeb.clickMSizeButton();
    }

    @And("Click to \"SEPETE EKLE\" Button")
    public void clickAddToCart() {
        productPageWeb.clickAddToCart();
    }

    @And("Click to \"Sepetim\" Button")
    public void clickToMyCartButton() {
        productPageWeb.clickMyCartButton();
    }
}
