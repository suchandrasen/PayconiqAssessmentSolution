package com.payconiq.assessment.pages;

import com.payconiq.assessment.util.Utilities;
import org.openqa.selenium.WebDriver;
import com.payconiq.assessment.util.Constants;

/**
 *
 * @author suchandras
 */
public class AddComputerPage {

    /**
     * Constant strings specific to Add computer page
     */
    private static final String ADD_COMPUTER_MESSAGE_ONE = "Done! Computer ";
    private static final String ADD_COMPUTER_MESSAGE_TWO = " has been created";
    private static final String ADD_COMPUTER_URL = "/new";

    /**
     * Verifying that add a computer page is open
     *
     * @param driver
     */
    public void checkAddPage(WebDriver driver) {
        Utilities.checkURL(driver, ADD_COMPUTER_URL);
    }

    /**
     * Filling in a computer name while adding a computer
     *
     * @param computerName
     * @param driver
     */
    public void setComputerName(String computerName, WebDriver driver) {
        Utilities.fillTextBox(driver, Constants.XPATH_INPUT_COMPUTERNAME, computerName);
    }

    /**
     * Filling in a introduced date while adding a computer
     *
     * @param introducedDate
     * @param driver
     */
    public void setIntroducedDate(String introducedDate, WebDriver driver) {
        Utilities.fillTextBox(driver, Constants.XPATH_INPUT_INTRODUCEDDATE, introducedDate);
    }

    /**
     * Filling in a discontinued date while adding a computer
     *
     * @param discontinuedDate
     * @param driver
     */
    public void setDiscontinuedDate(String discontinuedDate, WebDriver driver) {
        Utilities.fillTextBox(driver, Constants.XPATH_INPUT_DISCONTINUEDDATE, discontinuedDate);
    }

    /**
     * Selecting a company name while adding a computer
     *
     * @param companyName
     * @param driver
     */
    public void setCompanyName(String companyName, WebDriver driver) {
        Utilities.selectFromDropDown(driver, Constants.XPATH_INPUT_COMPANY, companyName);
    }

    /**
     * Saving the details
     *
     * @param driver
     */
    public void clickOnCreatethisComputerButton(WebDriver driver) {
        Utilities.clickButton(driver, Constants.XPATH_SUBMIT_COMPUTER);
    }

    /**
     * Verifying that when field validations fail, the corresponding element is
     * highlighted in red
     *
     * @param driver
     * @param elementName
     */
    public void checkErrorFieldHighlighted(WebDriver driver, String elementName) {
        Utilities.checkErrorInFieldHighlighted(driver, elementName);
    }

    /**
     * Adding the added computer name to the success message of adding a
     * computer
     *
     * @param computerName
     * @return
     */
    public String setFullMessage(String computerName) {
        return (ADD_COMPUTER_MESSAGE_ONE + computerName + ADD_COMPUTER_MESSAGE_TWO);
    }

    /**
     * Verifying the success message after adding a computer
     *
     * @param driver
     * @param newComputerName
     */
    public void checkNewComputerCreated(WebDriver driver, String newComputerName) {
        String addComputerMessage = setFullMessage(newComputerName);
        Utilities.verifyMessages(driver, Constants.XPATH_MESSAGE_COMPUTER, addComputerMessage);
    }
}
