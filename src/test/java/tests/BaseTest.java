package tests;

import Config.BrowserManagment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;

    String browser="";
    String env="";
    @BeforeTest
    public void SetupEnvironmentAndBrowser(){
       String Env=System.getProperty("env","test");
       driver= BrowserManagment.SetDriver();
       //String SiteUrl=ConfigurationManager.GetInstance(Env).GetProperty("url");
       String SiteUrl="https://www.google.com";
       driver.get(SiteUrl);
    }


    public WebDriver GetDriver(){return driver;}
    @AfterTest
    public void TearDown() throws IOException {
              driver.quit();
    }







}
