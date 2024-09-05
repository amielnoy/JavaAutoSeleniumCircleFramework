package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class BrowserManagment {
    static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver SetDriver(String browser) {
        ChromeOptions chromeOptions ;
        FirefoxOptions firefoxOptions ;

        if(Objects.equals(browser, "CHROME")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\untitled1\\src\\drivers\\chromedriver.exe");

            // Set the path to the local Chrome executable
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\user\\IdeaProjects\\untitled1\\src\\drivers\\chromedriver.exe");
            if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
                driver.set(new ChromeDriver(chromeOptions));
            } else {
                driver.set(new ChromeDriver());
            }
        }

        return driver.get();
    }

}
