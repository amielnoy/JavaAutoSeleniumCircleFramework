package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
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
