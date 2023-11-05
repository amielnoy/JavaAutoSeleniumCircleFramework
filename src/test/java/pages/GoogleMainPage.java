package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleMainPage extends BasePage {

    @FindBy(name= "q")
    private WebElement SearchBox;
    @FindBy(css = "ul.sbct li span")
    private List<WebElement> suggestionsList;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }
    public void enterText(String text){
        SearchBox.sendKeys(text);
    }

    public GoogleResultsPage SubmitSearch(){
        SearchBox.submit();
        return new GoogleResultsPage(driver);
    }




}
