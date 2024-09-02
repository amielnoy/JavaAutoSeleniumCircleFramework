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
public class GoogleTest extends BaseTest {

    @Test
    @Description("does 123 found in results")
    public void TestGoogleSearchFor123()  {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(getDriver());
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        for(int i=0;i <5;i++) {
            try {
                List<String> titelsList = GoogleResultsPage.getResultTitles();
                SeleniumSynchronization.waitForElementListToBeOfSize(getDriver(), titelsList, 7);
                return;
            }catch (Exception e){
                System.out.println("still waiting for number of titles to be="+7);
            }
        }
        GoogleResultsPage.CompareSearchResultTitle("תוספי תזונה");
    }
}
