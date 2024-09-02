package tests.TestCases;

import Utils.SeleniumSynchronization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;
import tests.BaseTest;

import java.util.List;

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
        for(int i=0;i <5;i++) {
            try {
                List<String> titelsList = GoogleResultsPage.getResultTitles();
                SeleniumSynchronization.waitForElementListToBeOfSize(getDriver(), titelsList, 10);
                return;
            }catch (Exception e){
                System.out.println("still waiting for number of titles to be="+10);
            }
        }
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }
}
