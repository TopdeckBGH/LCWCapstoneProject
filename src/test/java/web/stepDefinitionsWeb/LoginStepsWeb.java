package web.stepDefinitionsWeb;

import io.cucumber.java.en.Given;
import utils.DriverFactory;
import web.pagesWeb.LoginPageWeb;

public class LoginStepsWeb {

    LoginPageWeb loginPageWeb = new LoginPageWeb(DriverFactory.getWebDriver());

    @Given("User Logged In")
    public void login() {
        loginPageWeb.loginWebMail();
    }

}
