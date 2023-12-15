package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YogetaLoginPage extends BasePage {

    @FindBy(className = "card-body login-form-wrapper")
    private WebElement LoginForm;

    @FindBy(css = "input[type=\"email\"]")
    private WebElement Email;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement Password;

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    private WebElement SignInButton;


    public YogetaLoginPage(WebDriver driver) {
        super(driver);
    }
}
