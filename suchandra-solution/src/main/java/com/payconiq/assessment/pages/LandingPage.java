package com.payconiq.assessment.pages;

import com.payconiq.assessment.util.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author suchandras
 */
public class LandingPage {

    /**
     * Constant strings specific to the landing page of the application
     */
    private static final String XPATH_INPUT_FILTERTEXTBOX = "//*[@id='searchbox']";
    private static final String XPATH_SUBMIT_FILTERBUTTON = "//input[@id='searchsubmit']";
    private static final String XPATH_SUBMIT_NEWCOMPUTERBUTTON = "//*[@id='add']";
    private static final String XPATH_VERIFY_TEXT = "//*[@id=\"main\"]/h1";
    private static final String NORESULTS_MESSAGE = "No computers found";

    /**
     * Filling in a computer name for searching by the filter functionality
     *
     * @param driver
     * @param filterName
     */
    public void setTextForFilterByName(WebDriver driver, String filterName) {
        Utilities.fillTextBox(driver, XPATH_INPUT_FILTERTEXTBOX, filterName);
    }

    /**
     * Clicking on the filter button
     *
     * @param driver
     */
    public void clickOnFilterByNameButton(WebDriver driver) {
        Utilities.clickButton(driver, XPATH_SUBMIT_FILTERBUTTON);
    }

    /**
     * Checking the message if the search results do not show any data
     *
     * @param driver
     */
    public void verifyMessageNoResults(WebDriver driver) {
        Utilities.verifyMessages(driver, XPATH_VERIFY_TEXT, NORESULTS_MESSAGE);
    }

    /**
     * Navigating to the add new computer page
     *
     * @param driver
     */
    public void clickOnAddANewComputerButton(WebDriver driver) {
        Utilities.clickButton(driver, XPATH_SUBMIT_NEWCOMPUTERBUTTON);
    }

    /**
     * Navigating to the edit a computer page, by clicking
     * on the link of the computer name
     *
     * @param driver
     * @param computerName
     * @return the url of the edit computer page by fetching the id from href
     * tag of an existing computer in this landing page
     */
    public String clickOnExistingComputer(WebDriver driver, String computerName) {
        String urlForEditComputer = driver.findElement(By.linkText(computerName)).getAttribute("href");
        driver.findElement(By.linkText(computerName)).click();
        return urlForEditComputer;
    }
}
