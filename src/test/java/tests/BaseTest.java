package tests;

import Config.BrowserManagment;
import Config.ConfigurationManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

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
       String SiteUrl=ConfigurationManager.GetInstance(Env).GetProperty("url");
       driver.get(SiteUrl);
    }

    public  WebDriver GetDriver(){
        return driver;
    }

    public void CaptureErrorPage(ITestResult result) throws IOException {
        String testName = result.getName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String datetime = dtf.format(now);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = testName + "_" + datetime + ".png";
        FileUtils.copyFile(screenshot, new File("src/test/screenshots/" + fileName));
    }
    @AfterTest
    public void TearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE)
        {
            CaptureErrorPage(result);
        }
        driver.quit();
    }







}
