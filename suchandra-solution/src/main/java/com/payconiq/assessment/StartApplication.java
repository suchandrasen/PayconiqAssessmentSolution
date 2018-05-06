package com.payconiq.assessment;

import com.payconiq.assessment.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author suchandras
 */
public class StartApplication {


    public WebDriver openChrome() {
        /**
         * Starting the Chrome browser and returning the object of web driver
         */
        System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();

        return driver;
    }

    public WebDriver openFirefox() {
        /**
         * Starting the Chrome browser and returning the object of web driver
         */
        System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();

        return driver;
    }
}
