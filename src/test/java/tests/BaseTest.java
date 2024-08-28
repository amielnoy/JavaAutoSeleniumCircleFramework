package tests;

import Config.BrowserManagment;
import Config.ConfigurationManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
