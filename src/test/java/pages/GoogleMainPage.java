package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class GoogleMainPage extends BasePage {

    @FindBy(name= "q")
    private WebElement SearchBox;
    @FindBy(css = "ul.sbct li span")
    private List<WebElement> suggestionsList;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering search term")
    public void enterText(String text)  {
        for (char ch:text.toCharArray()) {
            SearchBox.sendKeys(String.valueOf(ch));
        }

    }
    @Step("Submit Search")
    public GoogleResultsPage SubmitSearch(){
        SearchBox.submit();
        return new GoogleResultsPage(driver);
    }




}
