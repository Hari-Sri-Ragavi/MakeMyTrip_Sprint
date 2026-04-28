@CabModule
Feature:MakeMyTrip Gift Cards - Browse, Select and Purchase

Background:
  Given open the browser
  And load the application URL
  And click on Cabs menu
  And select Outstation trip type
 
 Scenario: Verify all occasion categories are displayed
   And click on Search button
   And clicks OK if no cabs popup appears to proceed with available cabs
   And user clicks on the More menu from the results page
   And user selects Gift Cards from the More menu
   And user should be navigated to the Gift Cards page
   Then all occasion categories should be displayed
     

Scenario: Select an occasion gift card
    And click on Search button
    And clicks OK if no cabs popup appears to proceed with available cabs
   And user clicks on the More menu from the results page
   And user selects Gift Cards from the More menu
   And user should be navigated to the Gift Cards page
   When user selects gift occasion
   And user selects gift card
   Then gift card detail page should be displayed
 #this scenario use ExcelREader
Scenario: Select gift card amount and enter sender details
  And click on Search button
  And clicks OK if no cabs popup appears to proceed with available cabs
  And user clicks on the More menu from the results page
  And user selects Gift Cards from the More menu
  And user should be navigated to the Gift Cards page
  When user selects gift occasion
  And user selects gift card
  And user selects gift card amount
  And user enters sender name
  And user enters sender email
  And user enters sender mobile number
  Then verify entered
 