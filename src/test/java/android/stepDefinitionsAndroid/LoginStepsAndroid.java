package android.stepDefinitionsAndroid;

import android.pagesAndroid.LoginPageAndroid;
import android.pagesAndroid.TutorialPageAndroid;
import android.pagesAndroid.WelcomePageAndroid;
import io.cucumber.java.en.Given;
import utils.DriverFactory;

public class LoginStepsAndroid {

    TutorialPageAndroid tutorialPageAndroid = new TutorialPageAndroid(DriverFactory.getAppDriver());
    WelcomePageAndroid welcomePageAndroid = new WelcomePageAndroid(DriverFactory.getAppDriver());
    LoginPageAndroid loginPageAndroid = new LoginPageAndroid(DriverFactory.getAppDriver());

    @Given("User Logged In Android App")
    public void loginToAndroidApp() {
        tutorialPageAndroid.clickSkipButton();
        welcomePageAndroid.checkWelcomeLabel();
        welcomePageAndroid.clickProfileButton();
        loginPageAndroid.loginAndroidMail();
    }
}
