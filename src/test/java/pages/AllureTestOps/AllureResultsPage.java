package pages.AllureTestOps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.GoogleResultsPage;

import java.util.List;

public class AllureResultsPage extends BasePage {
    private final static String searchByNameXpathString= "//div[@data-testid='nav-Look up items-item']";

    @FindBy(xpath = searchByNameXpathString)
    WebElement searchByName;
    By searchByNameByXpath = By.xpath(searchByNameXpathString);

    @FindBy(css = "ul.sbct li span")
    private List<WebElement> suggestionsList;

    public AllureResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering search term")
    public void enterText(String searchedText)  {
            searchByName.clear();
            searchByName.sendKeys(searchedText);
        Utils.SeleniumSynchronization.waitForElementClickable(driver,searchByNameByXpath);
    }
}
