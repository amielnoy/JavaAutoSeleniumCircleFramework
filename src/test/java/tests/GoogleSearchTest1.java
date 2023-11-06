package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleResultsPage;

@Listeners(TestListner.class)
public class GoogleSearchTest1 extends BaseTest {

    @Test(description = "Failed 123 Test")
    public void SearchForSelenium() throws InterruptedException {
        GoogleMainPage GoogleMainPage= new  GoogleMainPage(driver);
        GoogleMainPage.enterText("123");
        GoogleResultsPage GoogleResultsPage = GoogleMainPage.SubmitSearch();
        GoogleResultsPage.CompareSearchResultTitle("Selenium");
    }

}
