package android.pagesAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.webUtils.ElementHelperAndroid;
import utils.JSONHelper;

public class LoginPageAndroid {

    public LoginPageAndroid(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 10);
        this.elementHelper = new ElementHelperAndroid(appiumDriver);
        this.jsonHelper = new JSONHelper();
    }

    AppiumDriver appiumDriver;
    WebDriverWait wait;
    ElementHelperAndroid elementHelper;
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
        Assert.assertEquals(elementHelper.getText(loginLabel), loginText);
    }

    public void loginAndroidMail(){
        elementHelper.sendKey(emailTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "mail"));
        elementHelper.sendKey(passwordTextField, jsonHelper.getAttributeFromJSON("src/test/resources/credentials/user1.json", "password"));
        elementHelper.click(loginButton);
    }

}
