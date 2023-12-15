package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YogetaDashBoard extends BasePage {

    @FindBy(className = "welcome-title")
    private WebElement WelcomeTitle;

    public YogetaDashBoard(WebDriver driver) {
        super(driver);
        IsElementDisplayed(WelcomeTitle);
    }


}
