package tests.TestCases;

import Utils.IpodItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TutorialsNinjaFirstPage;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Utils.PriceUtils.sortIpodItemsAndGetMinMax;

public class TestSortAlphabeticallyDecendingAndIpodStorage extends BaseTest {
    private ArrayList<String >resultsList;
    private TutorialsNinjaFirstPage tutorialsNinjaFirstPage;

    public static boolean isIpodNamesSorted(List<String> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }
    @Test
    public void SortAlphabeticallyDescendingTest() {
        ArrayList<String> resultsNamesList;
        String itemName = "";
        int listIndex;

        tutorialsNinjaFirstPage = new TutorialsNinjaFirstPage(getDriver());
        String textToSearch = "iPod";

        Assert.assertTrue(tutorialsNinjaFirstPage.getCurrency().isEnabled(),"Currency don't exists on page!!");
        Assert.assertTrue(tutorialsNinjaFirstPage.getCurrency().getText().contains("Currency"),
                    "****Currency don't appear!!****");

        tutorialsNinjaFirstPage.setSearch(textToSearch);
        tutorialsNinjaFirstPage.clickSearchButton();
        if (tutorialsNinjaFirstPage.clickSortAsListButton()) {
            tutorialsNinjaFirstPage.clickSortByNameAtoZOption();
            //Create a list of names
            resultsList = (ArrayList<String>) tutorialsNinjaFirstPage.getResultTitles();
            resultsNamesList = new ArrayList<>(resultsList.size());

            for (listIndex = 0; listIndex < resultsList.size(); ++listIndex) {
                itemName = resultsList.get(listIndex).split("\n")[0];
                resultsNamesList.add(itemName);
            }

            Assert.assertTrue(isIpodNamesSorted(resultsNamesList), "****Error: The list is not sorted in Acending order!!****");
        }
    }


    @Test
    public void ipodStorage() throws InterruptedException {
        SortAlphabeticallyDescendingTest();
        //Get only the visible images
        List<WebElement> ipodLinkElements=tutorialsNinjaFirstPage.getLinks().stream()
                .filter(link -> {
                    List<WebElement> images = link.findElements(By.tagName("img"));
                    return !images.isEmpty() && images.get(0).isDisplayed();
                })
                .toList();

        //run the sorting & extract all ipods items text to resultsList array list
        // Ensure you have resultsList populated somewhere before this operations
        ArrayList<IpodItem> IpodItemsArrayList = new ArrayList<IpodItem>(resultsList.size());


        for (int i = 0; i < resultsList.size(); ++i) {
            // Create a new instance of IpodItem for each iteration
            IpodItem ipodItem = new IpodItem();
            // Assuming the format in resultsList is consistent and has at least 4 items
            String[] parts = resultsList.get(i).split("\n");

            // Make sure to check the length of parts to avoid ArrayIndexOutOfBoundsException
            if (parts.length >= 4) {
                ipodItem.setName(parts[0]); // Assuming the name is at index 0
                ipodItem.setDescription(parts[1]); // Assuming description is at index 2
                ipodItem.setPrice(parts[2]);
                ipodItem.setUrl(ipodLinkElements.get(i).getAttribute("href"));
            } else {
                // Handle cases where you don't have enough parts for a valid IpodItem
                System.err.println("Warning: Not enough data to create an IpodItem from entry " + i);
            }

            // Now add the correctly populated ipodItem to the list
            IpodItemsArrayList.add(ipodItem);
        }

        double[] minMaxPrices = sortIpodItemsAndGetMinMax(IpodItemsArrayList);
        System.out.println("Min Price: $" + minMaxPrices[0]);
        System.out.println("Max Price: $" + minMaxPrices[1]);
    }

}
