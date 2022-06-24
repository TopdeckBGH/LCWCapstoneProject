package android.stepDefinitionsAndroid;

import android.pagesAndroid.LoginPageAndroid;
import android.pagesAndroid.TutorialPageAndroid;
import android.pagesAndroid.WelcomePageAndroid;
import io.cucumber.java.en.Given;
import utils.androidUtils.DriverFactoryAndroid;

public class LoginStepsAndroid {

    TutorialPageAndroid tutorialPageAndroid = new TutorialPageAndroid(DriverFactoryAndroid.getAppDriver());
    WelcomePageAndroid welcomePageAndroid = new WelcomePageAndroid(DriverFactoryAndroid.getAppDriver());
    LoginPageAndroid loginPageAndroid = new LoginPageAndroid(DriverFactoryAndroid.getAppDriver());

    @Given("User Logged In Android App")
    public void loginToAndroidApp() {
        tutorialPageAndroid.clickSkipButton();
        welcomePageAndroid.checkWelcomeLabel();
        welcomePageAndroid.clickProfileButton();
        loginPageAndroid.loginAndroidMail();
    }
}
