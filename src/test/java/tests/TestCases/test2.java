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
public class test2 extends BaseTest {

    @Test
    @Description("does Selenium found in results")
    public void SearchForSelenium() throws InterruptedException {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(driver);
        GoogleMainPage.enterText("Selenium");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }

}
