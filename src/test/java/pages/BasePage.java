package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void IsElementDisplayed(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void IsElementDisplayedWithTextIn(WebElement element, String Text)
    {
        wait.until(ExpectedConditions.textToBePresentInElement(element,Text));
    }
}
