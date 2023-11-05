package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;

public class GoogleSearchTest1 extends BaseTest {

    @Test
    public void SearchForSelenium()
    {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(driver);
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }

}
