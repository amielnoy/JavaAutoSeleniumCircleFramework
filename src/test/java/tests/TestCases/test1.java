package tests.TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;
import tests.BaseTest;
import tests.TestListner;

@Epic("Google regressions")
@Feature("Search Testing")
@Listeners(TestListner.class)
public class test1 extends BaseTest {

    @Test
    @Description("does text found in results")
    public void SearchFor123() throws InterruptedException {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(driver);
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }

}
