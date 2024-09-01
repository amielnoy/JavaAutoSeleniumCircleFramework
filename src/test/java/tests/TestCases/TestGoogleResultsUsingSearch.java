package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;
import tests.BaseTest;

@Epic("Google regressions")
@Feature("Search Testing")
@Listeners(TestListener.class)
public class TestGoogleResultsUsingSearch extends BaseTest {
    @Test
    @Description("does Selenium found in results")
    public void SearchForSelenium()  {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(getDriver());
        GoogleMainPage.enterText("Selenium");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }
}
