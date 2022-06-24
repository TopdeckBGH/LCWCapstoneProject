package utils.webUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactoryWeb {

    static WebDriver webDriver;
    static Properties properties;

    public static WebDriver initWebDriver(String browser) {

        properties = ConfigReader.getProperties();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("Firefox")){
            WebDriverManager.chromedriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }

        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));

        webDriver.get(url);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

        return getWebDriver();
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

}


