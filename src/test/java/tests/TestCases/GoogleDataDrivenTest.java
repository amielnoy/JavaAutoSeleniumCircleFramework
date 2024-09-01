package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;
import tests.BaseTest;

import java.util.List;

@Epic("Google regressions")
@Feature("Search Testing")
@Listeners(TestListener.class)
public class GoogleDataDrivenTest extends BaseTest {

    @DataProvider(name = "SearchString")
    public Object[][] provideGoogleSearchData() {
        return new Object[][] {
                {"Selenium"},
                {"Selenium: Benefits, Uses, Side Effects, Dosage, and More"}
        };
    }

    @Test(dataProvider = "SearchString")
    @Description("Verify search results for different search strings")
    public void testGoogleSearch(String search) {
        GoogleMainPage googleMainPage = new GoogleMainPage(getDriver());
        googleMainPage.enterText(search);
        GoogleResultsPage googleResultsPage = googleMainPage.SubmitSearch();

        List<String> googleSearchTitelsList=googleResultsPage.getResultTitles();
        Assert.assertTrue(googleSearchTitelsList.contains(search),
                "The search value="+search+" is missing from search titles!!");
    }
}

