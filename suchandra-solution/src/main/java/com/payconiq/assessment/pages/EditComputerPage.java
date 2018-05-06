package com.payconiq.assessment.pages;

import com.payconiq.assessment.util.Utilities;
import org.openqa.selenium.WebDriver;
import com.payconiq.assessment.util.Constants;

/**
 *
 * @author suchandras
 */
public class EditComputerPage {

    /**
     * Constant strings specific to Edit computer page
     */
    private static final String EDIT_COMPUTER_MESSAGE_ONE = "Done! Computer ";
    private static final String EDIT_COMPUTER_MESSAGE_TWO = " has been updated";
    private static final String DELETE_COMPUTER_MESSAGE = "Done! Computer has been deleted";

    /**
     * Filling in the new introduced date for editing a computer
     *
     * @param introducedDate
     * @param driver
     */
    public void editIntroducedDate(String introducedDate, WebDriver driver) {
        Utilities.fillTextBox(driver, Constants.XPATH_INPUT_INTRODUCEDDATE, introducedDate);
    }

    /**
     * Filling in the new discontinued date for editing a computer
     *
     * @param discontinuedDate
     * @param driver
     */
    public void editDiscontinuedDate(String discontinuedDate, WebDriver driver) {
        Utilities.fillTextBox(driver, Constants.XPATH_INPUT_DISCONTINUEDDATE, discontinuedDate);
    }

    /**
     * Filling in the new company name for editing a computer
     *
     * @param companyName
     * @param driver
     */
    public void editCompanyName(String companyName, WebDriver driver) {
        Utilities.selectFromDropDown(driver, Constants.XPATH_INPUT_COMPANY, companyName);
    }

    /**
     * Saving the changes
     *
     * @param driver
     */
    public void clickOnSavethisComputerButton(WebDriver driver) {
        Utilities.clickButton(driver, Constants.XPATH_SUBMIT_COMPUTER);
    }

    /**
     * Deleting a computer
     *
     * @param driver
     */
    public void clickOnDeleteThisComputerButton(WebDriver driver) {
        Utilities.clickButton(driver, Constants.XPATH_SUBMIT_DELETECOMPUTER);
    }

    /**
     * Adding the edited computer name to the success message of editing a
     * computer
     *
     * @param editComputerName
     * @return
     */
    public String setFullMessage(String editComputerName) {
        return (EDIT_COMPUTER_MESSAGE_ONE + editComputerName + EDIT_COMPUTER_MESSAGE_TWO);
    }

    /**
     * Verifying the success message after editing a computer
     *
     * @param driver
     * @param newComputerName
     */
    public void checkComputerEdited(WebDriver driver, String newComputerName) {
        String editComputerMessage = setFullMessage(newComputerName);
        Utilities.verifyMessages(driver, Constants.XPATH_MESSAGE_COMPUTER, editComputerMessage);
    }

    /**
     * Verifying the success message after deleting a computer
     *
     * @param driver
     */
    public void checkComputerDeleted(WebDriver driver) {
        Utilities.verifyMessages(driver, Constants.XPATH_MESSAGE_COMPUTER, DELETE_COMPUTER_MESSAGE);
    }
}
