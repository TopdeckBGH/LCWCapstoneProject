package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webUtils.DriverFactoryWeb;
import utils.webUtils.ElementHelperWeb;
import utils.JSONHelper;

public class LoginPageWeb {

    public LoginPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelperWeb = new ElementHelperWeb(driver);
        this.jsonHelper = new JSONHelper();
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperWeb elementHelperWeb;
    JSONHelper jsonHelper;

    HomePageWeb homePageWeb = new HomePageWeb(DriverFactoryWeb.getWebDriver());

    // Elements
    By mailTextField = By.cssSelector("[placeholder=\"E-Posta Adresiniz\"]");
    By passwordTextField = By.cssSelector("[placeholder=\"Şifreniz\"]");
    By loginButton = By.cssSelector("button.login-form__button");

    // Methods
    public void loginWebMail() {
        homePageWeb.clickLoginButton();
        elementHelperWeb.sendKey(mailTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "mail"));
        elementHelperWeb.sendKey(passwordTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "password"));
        elementHelperWeb.click(loginButton);
    }
}
