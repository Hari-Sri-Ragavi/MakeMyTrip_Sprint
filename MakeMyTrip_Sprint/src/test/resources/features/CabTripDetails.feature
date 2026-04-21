Feature:MakeMyTrip Cab Booking - Outstation One Way

Background:
  Given open the browser
  And load the application URL
  And click on Cabs menu
  And select Outstation trip type

# ---------------- SCENARIO 1 ----------------
Scenario: Search Outstation One Way cab
  When user enters valid trip details
  And click on Search button
  Then validate cab results are displayed

# ---------------- SCENARIO 2 ----------------
Scenario: Verify filter and Review Booking page
  When user enters valid trip details
  And click on Search button
  Then validate cab results are displayed
  When user filters cab type from the filter panel
  And user filters fuel type from the filter panel
  And user selects a cab from the filtered results
  Then user should be navigated to the Review Booking page

# ---------------- SCENARIO 3 ----------------
#Scenario Outline: Verify invalid mobile number error on Review Booking page
 # When user enters valid trip details
  #And click on Search button
  #Then validate cab results are displayed
  #When user filters cab type from the filter panel
  #And user filters fuel type from the filter panel
  #And user selects a cab from the filtered results
  #Then user should be navigated to the Review Booking page
  #And cab booking summary details should be displayed on the Review Booking page
  #When user enters mobile number "<mobile>" in the traveller details section
  #SAnd user clicks on Paynow button
 # Then system should display a validation error message "<errorMessage>"

Examples:
  | mobile      | #errorMessage                      |
  | 12345       | #Please enter valid mobile number |
 # | abcdefghij  | #Please enter valid mobile number |
  #| 99999999999 | #Please enter valid mobile number |
  
 # -----------scenario 4
  
#Scenario: Verify error for same From and To in Airport Transfers
 # And user selects Airport Transfers trip type
  #When user enters the same location in both From and To fields
  #And click on Search button
  #Then system should display an error message