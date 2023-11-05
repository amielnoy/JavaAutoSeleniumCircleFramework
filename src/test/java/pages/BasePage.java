package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void IsElementDisplaied(By by)
    {
        WebElement element=driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void IsElementDisplaiedWithTextIn(By by,String Text)
    {
        WebElement element=driver.findElement(by);
        wait.until(ExpectedConditions.textToBePresentInElement(element,Text));
    }




}
