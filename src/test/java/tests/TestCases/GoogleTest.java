package tests.TestCases;

import Utils.SeleniumSynchronization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected static final Logger logger = LogManager.getLogger(GoogleTest.class);

    @Test
    @Description("does 123 found in results")
    public void TestGoogleSearchFor()  {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(getDriver());
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();

        logger.info("Before Testing search results titles");
        List<String> titelsList = GoogleResultsPage.getResultTitles();
        SeleniumSynchronization.waitForElementListToBeOfSize(getDriver(), titelsList, 7);
        logger.info("still waiting for number of titles to be="+7);
        GoogleResultsPage.CompareSearchResultTitle("תוספי תזונה");
        logger.info("Test Passed");
    }
}
