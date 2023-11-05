package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleResultsPage extends BasePage {
    @FindBy(css = "div.g")
    private List<WebElement> searchResults;

    @FindBy(css = "h3.LC20lb")
    private List<WebElement> resultTitles;

    @FindBy(css = "div.VwiC3b > div > span")
    private List<WebElement> resultDescriptions;

    @FindBy(css = "cite.iUh30")
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
        IsElementDisplaied(new By.ByCssSelector("div.VwiC3b > div > span"));
    }

    public void CompareSearchResultTitle(String text){
        Assert.assertEquals(getResultTitles().contains(text),true," results not contain "+ text);
    }
}
