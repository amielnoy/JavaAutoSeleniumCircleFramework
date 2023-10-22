package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage extends BasePage {

    @FindBy
    private WebElement By SEARCH_BOX = By.name("q");

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSignIn;

    @FindBy(xpath = "//span[contains(text(),'viva test')]")
    WebElement lblUserName;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement lblInvalidEmail;

    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblInvalidPassword;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    //valid email and valid password
    public String doLogin(String email, String password) {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSignIn.click();

        return lblUserName.getText();
    }

    //Invalid email
    public String loginWithInvalidPassword(String email, String password) {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSignIn.click();

        return lblInvalidPassword.getText();
    }
}
