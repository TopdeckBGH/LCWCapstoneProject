package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.ElementHelper;
import utils.JSONHelper;

public class LoginPageWeb {

    public LoginPageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.jsonHelper = new JSONHelper();
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    JSONHelper jsonHelper;

    HomePageWeb homePageWeb = new HomePageWeb(DriverFactory.getDriver());

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
