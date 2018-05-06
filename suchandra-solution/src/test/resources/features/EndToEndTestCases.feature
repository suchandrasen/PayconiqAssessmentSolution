Feature: As a user of the computer database application, I want to be able to add the details of a new computer, 
edit the details of an existing computer, delete the details of an existing computer (when I no longer wish to keep it), 
and search by a computer name

@add
Scenario Outline:
Given I am on the computer database application in "<browserName>" browser
When I click on Add a new computer button 
And I am on the newcomputer page
And I enter a computer name
And I enter "<introducedDate>" in Introduced date
And I enter "<discontinuedDate>" in Discontinued date
And I select "<company>" from Company drop down
And I click on Create this computer button
And I get a creation success message 
And I enter that name in the filterByName text box
And I click on filterByName button
Then I see the computer in the result

Examples:
| browserName | introducedDate | discontinuedDate | company |
|    chrome   |   1988-02-02   |    2024-02-03    | Nokia   |
|    firefox  |   2001-05-07   |    2009-02-04    | RCA     |

@edit
Scenario Outline: 
Given I am on the computer database application in "<browserName>" browser
When I create a computer for "<action>" with a name and "<introducedDate>" as Introduced date and "<company>" as Company
And I search this computer created for "<action>"
And I click on this computer created for "<action>"
And I am on the edit computer page
And I enter new value "<introducedDateNew>" in Introduced date
And I select new value "<companyNew>" from Company drop down
And I click on Save this computer button
And I get a update success message 
When I search this computer created for "<action>"
Then I see the updated computer with "<introducedDateNew>" as Introduced date and "<companyNew>" from Company drop down in the result

Examples:
| browserName | action | introducedDate | company | introducedDateNew | companyNew |
|    chrome   |  edit  |    1988-02-02    | Nokia   |     2008-02-02      |   Canon    |
|    firefox  |  edit  |    2001-05-07    | RCA     |     1976-03-01      |   Sony     |
    


@delete
Scenario Outline:
Given I am on the computer database application in "<browserName>" browser
And I create a computer for "<action>" with a name and "<introducedDate>" as Introduced date and "<company>" as Company
When I search this computer created for "<action>"
And I click on this computer created for "<action>"
And I am on the edit computer page
And I click on Delete this computer button
And I get a delete success message
When I search this computer created for "<action>"
Then I see a notification message Nothing to display on the screen

Examples:
| browserName |  action  | introducedDate | company | 
|    chrome   |  delete  |    1988-02-02    | Nokia   |  
|    firefox  |  delete  |    2001-05-07    | RCA     | 

@search
Scenario Outline:
Given I am on the computer database application in "<browserName>" browser
When I enter "<searchText>" in the filterByName text box
And I click on filterByName button
Then all the results should contain "<searchText>"

Examples:
| browserName | searchText | 
|    chrome   |      a     | 
|    firefox  |      b     |   
