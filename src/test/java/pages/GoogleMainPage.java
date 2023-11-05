package pages;

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
    public void enterText(String text)  {
        for (char ch:text.toCharArray()) {
            SearchBox.sendKeys(String.valueOf(ch));
        }

    }

    public GoogleResultsPage SubmitSearch(){
        SearchBox.submit();
        return new GoogleResultsPage(driver);
    }




}
