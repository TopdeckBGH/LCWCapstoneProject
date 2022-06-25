package utils.androidUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactoryAndroid {

    static Properties properties;
    static AppiumDriver appiumDriver;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initAppDriver(String browser) {
        properties = ConfigReader.getProperties();

        capabilities = new DesiredCapabilities();
        if (browser.equals("Android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("appPackage", "com.lcwaikiki.android");
            capabilities.setCapability("appActivity", "com.lcwaikiki.android.ui.SplashActivity");
        } else if (browser.equals("iOS")) {

        }
        try {
            appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        appiumDriver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getAppDriver();
    }

    public static AppiumDriver getAppDriver() {
        return appiumDriver;
    }
}