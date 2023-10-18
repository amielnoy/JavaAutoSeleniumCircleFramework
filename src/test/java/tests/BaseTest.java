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


    }

}
