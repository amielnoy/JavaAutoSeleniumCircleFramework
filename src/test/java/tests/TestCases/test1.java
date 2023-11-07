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
public class test1 extends BaseTest {

    @Test
    @Description("does 123 found in results")
    public void SearchFor123() throws InterruptedException {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(driver);
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }

}
