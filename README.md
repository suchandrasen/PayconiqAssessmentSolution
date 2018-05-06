# PayconiqAssessmentSolution
Solution for Test Assessment

### Prerequisites

* Maven(version 3.5 or above) and Java(version 7 or above) 
* Browsers: Chrome and Firefox(latest versions)

### Running the tests

1. Check out the project
2. Go to the root folder of the project, in this case suchandra-solution.
3. If all the tests are to be run, then run the following command-
  mvn clean test
4. If any specific test is to be run, then any cucumber tag can be used as below-
  mvn clean test -Dcucumber.options="src/test/resources/features --tags @add"
  possible tag values - add, edit, delete, search, emptyComputerName, invalidIntroducedDate, invalidSearch

  
### About the framework

* This is a scenario based testing framework based on Java-Selenium with Junit and Cucumber
* The utility package under src/main/java contains reusable actions to be performed across all pages and also holds the reusable strings
* The pages package under src/main/java holds the representation of each page used in the tests as a java class
* The file StepDefintion.java in src/test/java is the realization of the scenarios mentioned in the feature files
* The test cases are in the feature files within src/test/resources/features
