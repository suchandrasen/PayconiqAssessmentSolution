package com.payconiq.assessment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author suchandras
 */
public class Utilities {

    private Utilities() {
    }

    /**
     * Reusable method to handle all text boxes
     *
     * @param driver
     * @param textXpath
     * @param text
     */
    public static void fillTextBox(WebDriver driver, String textXpath, String text) {
        WebElement textBox = driver.findElement(By.xpath(textXpath));
        textBox.clear();
        textBox.sendKeys(text);
    }

    /**
     * Reusable method to handle all buttons
     *
     * @param driver
     * @param buttonXpath
     */
    public static void clickButton(WebDriver driver, String buttonXpath) {
        WebElement button = driver.findElement(By.xpath(buttonXpath));
        button.click();
    }

    /**
     * Reusable method to handle all drop down lists
     *
     * @param driver
     * @param dropDownXpath
     * @param companyName
     */
    public static void selectFromDropDown(WebDriver driver, String dropDownXpath, String companyName) {
        WebElement dropDown = driver.findElement(By.xpath(dropDownXpath));
        Select companyNameDropDown = new Select(dropDown);
        companyNameDropDown.selectByVisibleText(companyName);
    }

    /**
     * Reusable method to verify all message notifications
     *
     * @param driver
     * @param xpathForActualMessage
     * @param expectedMessage
     */
    public static void verifyMessages(WebDriver driver, String xpathForActualMessage, String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath(xpathForActualMessage)).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Reusable method to verify that the correct page is opened
     *
     * @param driver
     * @param url
     */
    public static void checkURL(WebDriver driver, String url) {
        String nowUrl = driver.getCurrentUrl();
        String toCheckURLWith = Constants.BASE_URL.concat(url);
        Assert.assertEquals(nowUrl, toCheckURLWith);
    }

    /**
     * Reusable method to highlight all the fields with errors
     *
     * @param driver
     * @param elementName
     */
    public static void checkErrorInFieldHighlighted(WebDriver driver, String elementName) {
        WebElement errorElement = driver.findElement(By.cssSelector(Constants.CSS_SELECTOR_ERROR));
        Assert.assertTrue("Field with error is :" + errorElement.getText(), errorElement.isDisplayed());
        Assert.assertTrue(errorElement.getText().contains(elementName));
    }

    /**
     * converting dates from the format its accepted in while creating/editing a computer entry
     * to the format it displays in the search results
     * 
     * @param introducedDate
     * @return
     * @throws ParseException 
     */
    public static String convertDateFormat(String introducedDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATEFORMAT_ADDEDIT);
        Date date = simpleDateFormat.parse(introducedDate);
        String formatedIntroducedDate = new SimpleDateFormat(Constants.DATEFORMAT_DISPLAY).format(date);
        return formatedIntroducedDate;
    }
}
