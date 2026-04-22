Feature:MakeMyTrip Cab Booking - Outstation One Way

Background:
  Given open the browser
  And load the application URL
  And click on Cabs menu
  And select Outstation trip type

# ---------------- SCENARIO 1 ----------------
Scenario: Search Outstation One Way cab
 # When user enters valid trip details 
   And the user enters source for cab "<src>"
   And the user enters destination for cab  "<dest>"
   And click on Search button
   Then validate cab results are displayed
    Examples:
      | src    | dest    |
      | Delhi | Bangalore|
      #|Mumbai | Kolkata  |

# ---------------- SCENARIO 2 ----------------
Scenario: Verify filter and Review Booking page
 # When user enters valid trip details
  And click on Search button
  Then validate cab results are displayed
  When user filters cab type from the filter panel
  And user filters fuel type from the filter panel
  And user selects a cab from the filtered results
  #Then user should be navigated to the Review Booking page

# ---------------- SCENARIO 3 ----------------
  Scenario: Verify invalid mobile number error on Review Booking page
  And click on Search button
  Then validate cab results are displayed
  When user filters cab type from the filter panel
  And user filters fuel type from the filter panel
  And user selects a cab from the filtered results
  Then user should be navigated to the Review Booking page
  And cab booking summary details should be displayed on the Review Booking page

  When user enters mobile numbers in traveller details
    | 12345      |
    | 999999999  |
    | abcde      |
 When user enters email in traveller details
    | 333     |     
    | 000           |
    | renukasree    |
  And user clicks on Paynow button
  Then verify Shows Error Message
  