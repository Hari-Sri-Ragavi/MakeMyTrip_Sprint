Feature: MakeMyTrip Cab Booking - Outstation One Way

 

  Background:
    Given open the browser
    And load the application URL
    And click on Cabs menu
    And select Outstation trip type
    And select One Way option

  Scenario: Search Outstation One Way cab
    When user enters valid trip details
    And click on Search button
    Then validate cab results are displayed

  Scenario: Verify filter and Review Booking page
    Then validate cab results are displayed
    When user filters cab type from the filter panel
    And user filters fuel type from the filter panel
    And user selects a cab from the filtered results
    Then user should be navigated to the Review Booking page

  Scenario: Verify invalid mobile number error on Review Booking page
    Then user should be navigated to the Review Booking page
    And cab booking summary details should be displayed on the Review Booking page
    When user enters an invalid mobile number in the traveller details section
    And user clicks on Paynow button
    Then system should display a validation error message for invalid mobile number

  Scenario: Verify error for same From and To in Airport Transfers
    Given user selects Airport Transfers trip type from the Cabs menu
    When user enters the same location in both From and To fields
    And click on Search button
    Then system should display an error message indicating From and To locations cannot be the same location