package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class BrowserManagment {
    static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver SetDriver(String browser) {
        ChromeOptions chromeOptions = null;
        FirefoxOptions firefoxOptions = null;

        if(Objects.equals(browser, "CHROME")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
                driver.set(new ChromeDriver(chromeOptions));
            } else {
                driver.set(new ChromeDriver());
            }
        }

        else if(Objects.equals(browser, "FIREFOX")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            WebDriverManager.firefoxdriver().create();
            if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
                driver.set(new FirefoxDriver(firefoxOptions));
            } else {
                driver.set(new FirefoxDriver());
            }
        }

        return driver.get();
    }

}
