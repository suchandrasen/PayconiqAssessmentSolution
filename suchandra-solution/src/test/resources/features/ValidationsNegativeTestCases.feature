Feature: As a user of the computer database application, I want to know with a message or an error, 
when I am passing wrong inputs 

@emptyComputerName
Scenario Outline: 
Given I am on the computer database application in "<browserName>" browser
When I click on Add a new computer button
And I click on Create this computer button
Then the error on "Computer name" field should be highlighted

Examples:
|browserName|
| firefox   |
|  chrome   |

@invalidIntroducedDate
Scenario Outline:
Given I am on the computer database application in "<browserName>" browser
When I click on Add a new computer button
And I enter a computer name
And I enter "<introducedDate>" in Introduced date
And I click on Create this computer button
Then the error on "Introduced date" field should be highlighted

Examples:
|browserName | introducedDate |
|   chrome   |    29-10-1945    |
|   chrome   |    1988-01-40    |
|   firefox  |    1945-15-02    |
|   firefox  |    1988/11/11    |

@invalidSearch
Scenario Outline:
Given I am on the computer database application in "<browserName>" browser
When I enter "<non existant text>" in the filterByName text box
And I click on filterByName button
Then I see a notification message Nothing to display on the screen


Examples:
|browserName | non existant text |
|   chrome   |        <@@>       |
|   firefox  |        <@@>       |