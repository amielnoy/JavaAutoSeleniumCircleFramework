package tests;

import Config.BrowserManagment;
import Config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static ThreadLocal<WebDriver> ThreadLocalDriver=new ThreadLocal<>();
    String browser="";
    String env="";
    @BeforeTest
    public void SetupEnvironmentAndBrowser(){
       String Env=System.getProperty("env","test");
       WebDriver driver= BrowserManagment.SetDrover();
       ThreadLocalDriver.set(driver);
       String SiteUrl=ConfigurationManager.GetInstance(Env).GetProperty("url");
       driver.get(SiteUrl);
    }

    public static WebDriver getDriver(){
        return ThreadLocalDriver.get();
    }
    @AfterTest
    public void TearDown()
    {
        getDriver().quit();
        ThreadLocalDriver.remove();
    }







}
