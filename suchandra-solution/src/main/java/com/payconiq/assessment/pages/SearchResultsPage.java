package com.payconiq.assessment.pages;

import com.payconiq.assessment.util.Constants;
import com.payconiq.assessment.util.Utilities;
import java.text.ParseException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author suchandras
 */
public class SearchResultsPage {

    /**
     * Constant strings specific to the Search results pages
     */
    private static final String XPATH_TABLE_RESULTS = "//*[@id=\"main\"]/table/tbody";
    private static final String XPATH_TEXT_PAGINATION = "//*[@id='pagination']/ul/li[2]/a";

    /**
     * Searching a computer which has just been edited
     *
     * @param driver
     * @param introducedDate
     * @param companyName
     * @throws java.text.ParseException
     */
    public void checkResult(WebDriver driver, String introducedDate, String companyName) throws ParseException {

        List<WebElement> tableContents = driver.findElements(By.xpath(XPATH_TABLE_RESULTS));
        Assert.assertTrue(tableContents.get(0).getText().contains(companyName));
        Assert.assertTrue(tableContents.get(0).getText().contains(Utilities.convertDateFormat(introducedDate)));
    }

    /**
     * Searching for search results by going to each page of the results
     *
     * @param driver
     * @param searchText
     */
    public void searchInResults(WebDriver driver, String searchText) {

        WebElement pagination = driver.findElement(By.xpath(XPATH_TEXT_PAGINATION));
        String[] paginationText = pagination.getText().split(" ");

        int totalResults = Integer.parseInt(paginationText[5]);
        int totalPages;

        /**
         * Calculating total number of pages in the search result
         */
        if (totalResults % 10 == 0) {
            totalPages = totalResults / 10;
        } else {
            totalPages = (totalResults / 10) + 1;
        }

        /**
         * Matching the search text with the computer name in all the rows of
         * all pages of the search results
         */
        for (int i = 0; i <= totalPages; i++) {

            WebElement tableContent = driver.findElement(By.xpath(XPATH_TABLE_RESULTS));
            List<WebElement> rowCollection = tableContent.findElements(By.xpath("tr"));
            for (WebElement tdElement : rowCollection) {
                List<WebElement> tdCollection = tdElement.findElements(By.xpath("td"));

                Assert.assertTrue(tdCollection.get(0).getText().toLowerCase().contains(searchText));
            }
            
            /**
             * Clicking on the next page button to navigate to the next page
             */
            if (i < totalPages) {
                driver.navigate().to(Constants.BASE_URL + "?p=" + i + "&f=" + searchText);
            }
        }
    }
}
