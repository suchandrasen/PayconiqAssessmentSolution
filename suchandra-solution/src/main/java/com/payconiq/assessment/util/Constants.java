package com.payconiq.assessment.util;

/**
 *
 * @author suchandras
 */
public class Constants {
    
    private Constants(){
        // preventing initialization of this class
    }
    
    public static final String BASE_URL = "http://computer-database.herokuapp.com/computers";
    
    /**
     * Reusable XPaths
     */
    public static final String XPATH_INPUT_COMPUTERNAME = "//*[@id='name']";
    public static final String XPATH_INPUT_INTRODUCEDDATE = "//*[@id='introduced']";
    public static final String XPATH_INPUT_DISCONTINUEDDATE = "//*[@id='discontinued']";
    public static final String XPATH_INPUT_COMPANY = "//*[@id='company']";
    public static final String XPATH_SUBMIT_COMPUTER = "//input[@class=\"btn primary\"]";
    public static final String XPATH_MESSAGE_COMPUTER = "//*[@class=\"alert-message warning\"]";
    public static final String XPATH_SUBMIT_DELETECOMPUTER = "//input[@class=\"btn danger\"]";
    public static final String CSS_SELECTOR_ERROR = "div[class='clearfix error']";
    
    /**
     * To have a unique computer name for each operation
     */
    public static final String ADD_COMPUTER_NAME = "addtest" + Long.toString(System.currentTimeMillis());
    public static final String EDIT_COMPUTER_NAME = "edittest" + Long.toString(System.currentTimeMillis());
    public static final String DELETE_COMPUTER_NAME = "deletetest" + Long.toString(System.currentTimeMillis());
    
    /**
     * Flags to identify the actions
     */
    public static final String DELETE_FLAG = "delete";
    public static final String EDIT_FLAG = "edit";
    
    /**
     * Date format constants
     */
    public static final String DATEFORMAT_ADDEDIT= "yyyy-MM-dd";
    public static final String DATEFORMAT_DISPLAY= "dd MMM yyyy";
    
}
