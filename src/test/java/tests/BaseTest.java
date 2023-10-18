package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    String browser="";
    String env="";
    @BeforeSuite
    public void SetupEnvironmentAndBrowser(){
        browser=System.getProperty("browser","ch");
        env=System.getProperty("env","test");
        if(browser.equalsIgnoreCase("ch"))
        {
            WebDriverManager.chromedriver().setup();
        }
        if(browser.equalsIgnoreCase("ff"))
        {
            WebDriverManager.chromedriver().setup();
        }


    }

}
