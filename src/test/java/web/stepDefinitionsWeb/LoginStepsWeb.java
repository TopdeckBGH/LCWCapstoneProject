package web.stepDefinitionsWeb;

import io.cucumber.java.en.Given;
import utils.webUtils.DriverFactoryWeb;
import web.pagesWeb.LoginPageWeb;

public class LoginStepsWeb {

    LoginPageWeb loginPageWeb = new LoginPageWeb(DriverFactoryWeb.getWebDriver());

    @Given("User Logged In")
    public void login() {
        loginPageWeb.loginWebMail();
    }

}
