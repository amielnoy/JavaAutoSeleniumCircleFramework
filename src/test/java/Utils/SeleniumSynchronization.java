package Utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SeleniumSynchronization {

    private static final long DEFAULT_TIMEOUT = 20;
    private static final long DEFAULT_POLLING_INTERVAL = 500;

    public static void implicitWait(WebDriver driver, long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }

    public static void waitTillInputWasSetWithText(WebDriver driver,WebElement inputWebElement,String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(inputWebElement),
                ExpectedConditions.attributeContains(inputWebElement, "value", expectedText)
        ));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementInvisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static WebElement fluentWait(WebDriver driver, final By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    public static void staticWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Custom condition
    public static boolean waitForCustomCondition(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(driver1 -> {
            WebElement element = driver1.findElement(locator);
            return element.isDisplayed() && element.isEnabled();
        });
    }

    // Custom condition
    public static void waitForElementListToBeOfSize(WebDriver driver, List<String> list, int listCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(driver1 -> list.size() == listCount);
    }

    public static void waitForElementText(WebDriver driver,WebElement webElement,String expectedText)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> webElement.getText().equalsIgnoreCase(expectedText));
    }
}
