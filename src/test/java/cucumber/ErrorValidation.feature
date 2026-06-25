@tag
Feature:Purchase the order from E commerce website
Background:
Given I land on Ecommerce page
@ErrorValidation
Scenario Outline:Postive test of submitting the order


Given Logged in with username <name> and passwordd<passwordd> 


  
Then "Incorrect email  password." message is displayed 
Examples:
| name               | passwordd     | 
| tvorvoi@gmail.com  |Kampli@1234   | 


