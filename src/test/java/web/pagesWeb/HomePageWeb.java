package web.pagesWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

public class HomePageWeb {

    public HomePageWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    // Elements
    By loginButton = By.cssSelector("a[href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"] span.dropdown-label");

    // Methods
    public void clickLoginButton(){
        elementHelper.click(loginButton);
    }

}
