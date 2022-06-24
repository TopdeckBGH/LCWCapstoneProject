package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webUtils.DriverFactoryWeb;
import utils.webUtils.ElementHelperAndroid;
import utils.JSONHelper;

public class LoginPageWeb {

    public LoginPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelperAndroid(driver);
        this.jsonHelper = new JSONHelper();
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;
    JSONHelper jsonHelper;

    HomePageWeb homePageWeb = new HomePageWeb(DriverFactoryWeb.getWebDriver());

    // Elements
    By mailTextField = By.cssSelector("[placeholder=\"E-Posta Adresiniz\"]");
    By passwordTextField = By.cssSelector("[placeholder=\"Şifreniz\"]");
    By loginButton = By.cssSelector("button.login-form__button");

    // Methods
    public void loginWebMail() {
        homePageWeb.clickLoginButton();
        elementHelper.sendKey(mailTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "mail"));
        elementHelper.sendKey(passwordTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "password"));
        elementHelper.click(loginButton);
    }
}
