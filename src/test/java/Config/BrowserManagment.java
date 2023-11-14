package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManagment {
    static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver SetDriver() {
        String browser = System.getProperty("browser", "ch");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");

        if (browser.equalsIgnoreCase("ch")) {
            WebDriverManager.chromedriver().setup();
            if (System.getProperty("os.name").toLowerCase().equals("linux")) {
                driver.set(new ChromeDriver(chromeOptions));
            } else {
                driver.set(new ChromeDriver());
            }
        }
        if (browser.equalsIgnoreCase("ff")) {
            WebDriverManager.firefoxdriver().create();
            if (System.getProperty("os.name").toLowerCase().equals("linux")) {
                driver.set(new FirefoxDriver(firefoxOptions));
            } else {
                driver.set(new FirefoxDriver());
            }
        }
        //driver.manage().window().max();
        return driver.get();
    }

}
