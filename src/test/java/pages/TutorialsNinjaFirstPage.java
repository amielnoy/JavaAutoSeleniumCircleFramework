package pages;

import Utils.SeleniumSynchronization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TutorialsNinjaFirstPage extends BasePage {
    //private  final String PAGE_URL= PropertiesHandler.getProperty("Infrastructure/config_files/configuration.properties","URL");
    private final String searchButtonCss = "i.fa.fa-search";
    private final String listViewSortingId = "list-view";

    @FindBy(css = "button.btn.btn-link")
    private WebElement currency;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = searchButtonCss)
    private WebElement searchButton;

    @FindBy(id = "input-sort")
    private WebElement sortByButton;
    //click option - with index 1
    @FindBy(id = listViewSortingId)
    private WebElement listViewSearchResultsSortingButton;

    @FindBy(css = ".product-thumb")
    private List<WebElement> sortingResultsTitles;

    public List<String> getResultTitles() {
        return sortingResultsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public TutorialsNinjaFirstPage(WebDriver driver) {
        super(driver);
        navigateToUrl();
    }


    public void setSearch(String searchText) {
        searchBox.clear();
        searchBox.sendKeys(searchText);
        SeleniumSynchronization.waitTillInputWasSetWithText(driver, searchBox, searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
        SeleniumSynchronization.waitForElementClickable(driver, new By.ByCssSelector(searchButtonCss));
    }

    public boolean clickSortAsListButton() {
        listViewSearchResultsSortingButton.click();
        SeleniumSynchronization.waitForElementClickable(driver, By.id(listViewSortingId));
        return true;
    }

    public void clickSortByNameAtoZOption() {
        Select dropdown = new Select(sortByButton);
        dropdown.selectByVisibleText("Name (A - Z)");
        SeleniumSynchronization.waitForElementClickable(driver, new By.ByCssSelector(searchButtonCss));
    }

    public WebElement getCurrency() {
        return currency;
    }

    public List<WebElement> getLinks() {
      return links;
    }
}
