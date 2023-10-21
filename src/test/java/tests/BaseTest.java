package tests;

import Config.BrowserManagment;
import Config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    String browser="";
    String env="";
    @BeforeTest
    public void SetupEnvironmentAndBrowser(){
       String Env=System.getProperty("env","test");
       driver= BrowserManagment.SetDriver();
       String SiteUrl=ConfigurationManager.GetInstance(Env).GetProperty("url");
       driver.get(SiteUrl);
    }

    public  WebDriver GetDriver(){
        return driver;
    }
    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }







}
