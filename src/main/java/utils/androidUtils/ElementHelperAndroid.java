package utils.androidUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelperAndroid {
    AppiumDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelperAndroid(AppiumDriver driver) {
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

    /** Finds the given element without waiting.
     * @param key Distinctive value of the element.
     * @return Specified element is returned.
     */
    public WebElement findElementNoWait(By key) {
        WebElement element = driver.findElement(key);
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

    /**
     * Checks if the given element is visible.
     * @param key Distinctive value of the element.
     * @return Returns True, if the element is present; returns false otherwise.
     */
    public boolean assertElementIsVisible(By key){
        List<WebElement> elements = driver.findElements(key);
        if (elements.size() == 0){
            return false;
        }
        return true;
    }

    /** Drags on the coordinates of point firstX, firstY and drops on the coordinates of lastX, lastY.
     * @param firstX X-axis of drag operation.
     * @param firstY Y-axis of drag operation.
     * @param lastX X-axis of drop operation.
     * @param lastY Y-axis of drop operation.
     */
    public void dragAndDropElement(int firstX, int firstY, int lastX, int lastY) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(firstX,firstY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000))) //you can change wait durations as per your requirement
                .moveTo(PointOption.point(lastX, lastY))
                .release()
                .perform();
    }

}
