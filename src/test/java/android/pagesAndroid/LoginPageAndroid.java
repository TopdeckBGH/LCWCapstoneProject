package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.androidUtils.ElementHelperAndroid;
import utils.webUtils.ElementHelperWeb;
import utils.JSONHelper;

public class LoginPageAndroid {

    public LoginPageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelperAndroid = new ElementHelperAndroid(appiumDriver);
        this.jsonHelper = new JSONHelper();
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelperAndroid;
    JSONHelper jsonHelper;

    // Strings
    String loginText = "GİRİŞ YAP";

    // Elements
    By loginLabel = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/headerLogin\")");
    By emailTextField = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/edtEmail\")");
    By passwordTextField = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/edtPassword\")");
    By loginButton = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/buttonLogin\")");

    // Methods
    public void checkLoginPage(){
        Assert.assertEquals(elementHelperAndroid.getText(loginLabel), loginText);
    }

    public void loginAndroidMail(){
        elementHelperAndroid.sendKey(emailTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "mail"));
        elementHelperAndroid.sendKey(passwordTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "password"));
        elementHelperAndroid.click(loginButton);
    }

}
