package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleResultsPage extends BasePage {


    @FindBy(className = "logo")
    private WebElement Logo;

    @FindBy(css = "div.notranslate")
    private List<WebElement> searchResults;
    @FindBy(css = "h3.LC20lb")
    private List<WebElement> resultTitles;

    @FindBy(css = "div.VwiC3b")
    private List<WebElement> resultDescriptions;

    @FindBy(css = "cite.qLRx3b")
    private List<WebElement> resultUrls;

    public List<String> getResultTitles() {
        return resultTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getNumberOfResults() {
        return searchResults.size();
    }
    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        IsElementDisplayed(Logo);
    }

    @Step("Check that the term we searched is shown in the search results")
    public void CompareSearchResultTitle(String text){
        //Assert.assertTrue(getResultTitles().contains(text)," results not contain "+ text);
        Assert.fail(" results not contain "+ text);
    }
}
