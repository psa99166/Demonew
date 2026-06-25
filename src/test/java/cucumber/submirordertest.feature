@tag
Feature:Purchase the order from E commerce website
Background:
Given I land on Ecommerce page
@Regression
Scenario Outline:Postive test of submitting the order


Given Logged in with username <name> and passwordd<passwordd> 

When I add product <productName> to cart
And Checkout <productName> and submit the order
  
Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
Examples:
| name               | passwordd     | productName |
| tvorvoi@gmail.com  |Kampli@123    | ZARA COAT 3 |




