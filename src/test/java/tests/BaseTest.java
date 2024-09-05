package tests;

import Config.BrowserManagment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters({"browser", "env"})
    @BeforeMethod
    public WebDriver setupEnvironmentAndBrowser(@Optional("chrome") String browser, @Optional("test") String env) {
        logger.info("Starting to initialize browser");
        WebDriver webDriver = BrowserManagment.SetDriver("CHROME");
        driver.set(webDriver);
        logger.info("Finished initializing browser");
        logger.info("*****STARTING Selenium test*****");
        return webDriver;
    }

    protected WebDriver getDriver() {
        return driver.get();
    }


    @AfterMethod
    public void tearDown() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
        logger.info("*****Selenium test ENDED*****");
    }
}