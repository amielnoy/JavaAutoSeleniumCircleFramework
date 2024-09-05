package pages;

import Infra.PropertiesHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Config.GlobalConstants.MAX_TIMEOUT;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToUrl(){
        baseUrl= PropertiesHandler.getProperty("configuration.properties","BASE_URL");
        driver.get(baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/");
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
