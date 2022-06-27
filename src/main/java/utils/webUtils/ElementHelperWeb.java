package utils.webUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ElementHelperWeb {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelperWeb(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
    }

    /** Finds the given element.
     * @param key Distinctive value of the element.
     * @return Specified element is returned.
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        return element;
    }

    /** Finds given elements.
     * @param key Distinctive value of elements.
     * @return Specified elements are returned.
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /** Specified element is clicked.
     * @param key Distinctive value of the element.
     */
    public void click(By key) {
        findElement(key).click();
    }

    /** Given input is written in the specified element.
     * @param key Distinctive value of the element.
     * @param text Desired input.
     */
    public void sendKey(By key, String text) {
        findElement(key).sendKeys(text);
    }

    /** Returns specified element's text value.
     * @param key Distinctive value of the element.
     * @return Specified element's text value is returned.
     */
    public String getText(By key) {
        return findElement(key).getText();
    }

    /** Gets the specified elements specified attribute.
     * @param key Distinctive value of the element.
     * @param attr Specified attribute.
     * @return Text of the specified elements specified attribute.
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /** Gets specified element.
     * @param key Distinctive value of the element.
     * @return Specified WebElement.
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(key));
    }

    /** Gets specified elements.
     * @param key Distinctive value of the element.
     * @return Specified WebElements.
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(key));
    }

    /** Scrolls to WebElement.
     * @param element Given WebElement.
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

    public void hoverToElement(By key){
        WebElement element = presenceElement(key);
        action.moveToElement(element).perform();
    }


    public void hoverToElementWithText(By key, String text) {
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                action.moveToElement(element).perform();
                break;
            }
        }
    }


    public void clickToLocation(int xOffset, int yOffset){
        action.moveByOffset(xOffset, yOffset).click().perform();
    }

    public boolean assertElementIsVisible(By key){
        List<WebElement> elements = driver.findElements(key);
        if (elements.size() == 0){
            return false;
        }
        return true;
    }

}
