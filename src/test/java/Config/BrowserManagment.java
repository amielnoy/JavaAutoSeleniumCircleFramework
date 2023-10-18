package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManagment {
    public static WebDriver SetDrover(){
        String browser=System.getProperty("browser","ch");
        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();
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
