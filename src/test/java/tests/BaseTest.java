package tests;

import Config.BrowserManagment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters({"browser", "env"})
    @BeforeMethod
    public WebDriver setupEnvironmentAndBrowser(@Optional("chrome") String browser, @Optional("test") String env) {
        WebDriver webDriver = BrowserManagment.SetDriver("CHROME");
        driver.set(webDriver);

        String siteUrl = Config.ConfigurationManager.GetInstance(env).GetProperty("url");
        getDriver().get(siteUrl);
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
    }
}