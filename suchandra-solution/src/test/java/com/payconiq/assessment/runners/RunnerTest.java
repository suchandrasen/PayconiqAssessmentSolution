package com.payconiq.assessment.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author suchandras
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.payconiq.assessment.stepdefinitions"}
)
public class RunnerTest {
    
}
