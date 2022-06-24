package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webUtils.ElementHelperWeb;

public class HomePageWeb {

    public HomePageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperWeb = new ElementHelperWeb(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperWeb elementHelperWeb;

    // Elements
    By loginButton = By.cssSelector("a[href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"] span.dropdown-label");
    By fastDeliveryButton = By.cssSelector("[href=\"/tr-TR/TR/FastDelivery\"]");
    By categoryList = By.cssSelector("li.menu-header-item");
    By blouseButton = By.xpath("//*[contains(@href, '/tr-TR/TR/kategori/kadin/bluz')]");

    // Texts
    String womanCategory = "KADIN";

    // Methods
    public void clickLoginButton() {
        elementHelperWeb.click(loginButton);
    }

    public void hoverWomanButton() {
        elementHelperWeb.findElements(fastDeliveryButton);
        elementHelperWeb.hoverToElementWithText(categoryList, womanCategory);
    }

    public void clickBlouseButton() {
        elementHelperWeb.click(blouseButton);
    }

}
