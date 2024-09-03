package tests;

import Config.BrowserManagment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger();

    @Parameters({"browser", "env"})
    @BeforeMethod
    public WebDriver setupEnvironmentAndBrowser(@Optional("chrome") String browser, @Optional("test") String env) {
        WebDriver webDriver = BrowserManagment.SetDriver("CHROME");
        driver.set(webDriver);

        String siteUrl = Config.ConfigurationManager.GetInstance(env).GetProperty("url");
        getDriver().get(siteUrl);
        getLogger().info("*****Starting Selenium test*****");
        return webDriver;
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    protected Logger getLogger(){
        return BaseTest.logger;
    }

    @AfterMethod
    public void tearDown() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
        getLogger().info("*****Selenium test ENDED*****");
    }
}