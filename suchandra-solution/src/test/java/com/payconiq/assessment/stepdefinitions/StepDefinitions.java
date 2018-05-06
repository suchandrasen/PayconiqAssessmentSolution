package com.payconiq.assessment.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.payconiq.assessment.StartApplication;
import com.payconiq.assessment.pages.EditComputerPage;
import com.payconiq.assessment.pages.LandingPage;
import com.payconiq.assessment.pages.AddComputerPage;
import com.payconiq.assessment.pages.SearchResultsPage;
import com.payconiq.assessment.util.Constants;
import cucumber.api.java.After;
import java.text.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author suchandras
 */
public class StepDefinitions {

    private WebDriver driver;
    
    // url of the edit page is handled here as, the id of any existing computer (to be edited or deleted)
    // is returned in this page
    private String editPageUrl;
    
    private final StartApplication start = new StartApplication();

    // Creating objects of all page classes
    private final LandingPage landing = new LandingPage();
    private final AddComputerPage addComputerPage = new AddComputerPage();
    private final EditComputerPage editComputerPage = new EditComputerPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Given("^I am on the computer database application in \"([^\"]*)\" browser$")
    public void i_am_on_the_computer_database_application(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = start.openFirefox();
        } else {
            driver = start.openChrome();
        }
    }

    @When("^I enter \"([^\"]*)\" in the filterByName text box$")
    public void i_enter_in_the_filterByName_text_box(String filterName) {
        landing.setTextForFilterByName(driver, filterName);
    }

    @When("^I click on filterByName button$")
    public void i_click_on_filterByName_button() {
        landing.clickOnFilterByNameButton(driver);
    }

    @Then("^I see a notification message Nothing to display on the screen$")
    public void i_see_a_message_on_the_screen() {
        landing.verifyMessageNoResults(driver);
    }

    @When("^I click on Add a new computer button$")
    public void i_click_on_Add_a_new_computer_button() {
        landing.clickOnAddANewComputerButton(driver);
    }

    @When("^I click on Create this computer button$")
    public void i_click_on_Create_this_computer_button() {
        addComputerPage.clickOnCreatethisComputerButton(driver);
    }

    @Then("^the error on \"([^\"]*)\" field should be highlighted$")
    public void the_error_on_field_should_be_highlighted(String elementName) {
        addComputerPage.checkErrorFieldHighlighted(driver, elementName);
    }

    @When("^I am on the newcomputer page$")
    public void i_am_on_the_newcomputer_page() {
        addComputerPage.checkAddPage(driver);
    }

    @When("^I enter a computer name$")
    public void i_enter_a_computer_name() {
        addComputerPage.setComputerName(Constants.ADD_COMPUTER_NAME, driver);
    }

    @When("^I enter \"([^\"]*)\" in Introduced date$")
    public void i_enter_in_Introduced_date(String introducedDate) {
        addComputerPage.setIntroducedDate(introducedDate, driver);
    }

    @When("^I enter \"([^\"]*)\" in Discontinued date$")
    public void i_enter_in_Discontinued_date(String discontinuedDate) {
        addComputerPage.setDiscontinuedDate(discontinuedDate, driver);
    }

    @When("^I select \"([^\"]*)\" from Company drop down$")
    public void i_select_from_Company_drop_down(String companyName) {
        addComputerPage.setCompanyName(companyName, driver);
    }

    @When("^I get a creation success message$")
    public void i_get_a_creation_success_message() {
        addComputerPage.checkNewComputerCreated(driver, Constants.ADD_COMPUTER_NAME);
    }

    @When("^I enter that name in the filterByName text box$")
    public void i_enter_that_name_in_the_filterByName_text_box() {
        landing.setTextForFilterByName(driver, Constants.ADD_COMPUTER_NAME);
    }

    @Then("^I see the computer in the result$")
    public void i_see_the_computer_in_the_result() {
        searchResultsPage.searchInResults(driver, Constants.ADD_COMPUTER_NAME);
    }

    @When("^I create a computer for \"([^\"]*)\" with a name and \"([^\"]*)\" as Introduced date and \"([^\"]*)\" as Company$")
    public void i_create_a_new_computer(String flag, String introducedDate, String companyName) {
        landing.clickOnAddANewComputerButton(driver);
        if (flag.equals(Constants.EDIT_FLAG)) {
            addComputerPage.setComputerName(Constants.EDIT_COMPUTER_NAME, driver);
        } else if (flag.equals(Constants.DELETE_FLAG)) {
            addComputerPage.setComputerName(Constants.DELETE_COMPUTER_NAME, driver);
        }

        addComputerPage.setIntroducedDate(introducedDate, driver);
        addComputerPage.setCompanyName(companyName, driver);
        addComputerPage.clickOnCreatethisComputerButton(driver);
    }

    @When("^I search this computer created for \"([^\"]*)\"$")
    public void i_search_this_computer_created_for(String flag) {
        if (flag.equals(Constants.EDIT_FLAG)) {
            landing.setTextForFilterByName(driver, Constants.EDIT_COMPUTER_NAME);
        } else if (flag.equals(Constants.DELETE_FLAG)) {
            landing.setTextForFilterByName(driver, Constants.DELETE_COMPUTER_NAME);
        }
        landing.clickOnFilterByNameButton(driver);
    }

    @When("^I am on the edit computer page$")
    public void i_am_on_the_edit_computer_page() {
        Assert.assertEquals(driver.getCurrentUrl(), editPageUrl);
    }

    /**
     * Based on the flag, either the computer is edited or deleted
     * @param flag
     */
    @When("^I click on this computer created for \"([^\"]*)\"$")
    public void i_click_on_this_computer_created(String flag) {
        if (flag.equals(Constants.EDIT_FLAG)) {
            editPageUrl = landing.clickOnExistingComputer(driver, Constants.EDIT_COMPUTER_NAME);
        } else if (flag.equals(Constants.DELETE_FLAG)) {
            editPageUrl = landing.clickOnExistingComputer(driver, Constants.DELETE_COMPUTER_NAME);
        }
    }

    @When("^I enter new value \"([^\"]*)\" in Introduced date$")
    public void i_enter_new_value_in_Introduced_date(String editIntroducedDate) {
        editComputerPage.editIntroducedDate(editIntroducedDate, driver);
    }

    @When("^I select new value \"([^\"]*)\" from Company drop down$")
    public void i_select_new_value_from_Company_drop_down(String editCompany) {
        editComputerPage.editCompanyName(editCompany, driver);
    }

    @When("^I click on Save this computer button$")
    public void i_click_on_Save_this_computer_button() {
        editComputerPage.clickOnSavethisComputerButton(driver);
    }

    @When("^I get a update success message$")
    public void i_get_a_update_success_message() {
        editComputerPage.checkComputerEdited(driver, Constants.EDIT_COMPUTER_NAME);
    }

    @Then("^I see the updated computer with \"([^\"]*)\" as Introduced date and \"([^\"]*)\" from Company drop down in the result$")
    public void i_see_the_updated_computer_in_the_result(String editIntroducedDate, String editCompanyName) throws ParseException {
        searchResultsPage.checkResult(driver, editIntroducedDate, editCompanyName);
    }

    @When("^I search this computer created for deleting$")
    public void i_search_this_computer_created_for_deleting() {
        landing.setTextForFilterByName(driver, Constants.EDIT_COMPUTER_NAME);
        landing.clickOnFilterByNameButton(driver);
    }

    @When("^I click on Delete this computer button$")
    public void i_click_on_Delete_this_computer_button() {
        editComputerPage.clickOnDeleteThisComputerButton(driver);
    }

    @When("^I get a delete success message$")
    public void i_get_a_delete_success_message() {
        editComputerPage.checkComputerDeleted(driver);
    }

    @Then("^that computer entry should be removed$")
    public void that_computer_entry_should_be_removed() {
        editComputerPage.checkComputerDeleted(driver);
    }

    @Then("^all the results should contain \"([^\"]*)\"$")
    public void all_the_results_should_contain(String searchText) {
        searchResultsPage.searchInResults(driver, searchText);
    }

    /**
     * Closing of browser that's done after every test case
     */
    @After
    public void closeBrowser() {
        driver.close();
    }
}
