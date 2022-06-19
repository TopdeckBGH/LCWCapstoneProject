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
    By categoryList = By.cssSelector("li.menu-header-item");
    By blouseButton = By.xpath("//*[contains(@href, '/tr-TR/TR/kategori/kadin/bluz')]");

    // Texts
    String womanCategory = "KADIN";
    String blouse = "Bluz";

    // Methods
    public void clickLoginButton(){
        elementHelper.click(loginButton);
    }

    public void hoverWomanButton(){
        elementHelper.hoverElementWithText(categoryList, womanCategory);
    }

    public void clickBlouseButton(){
        elementHelper.click(blouseButton);
    }

}
