Feature: MakeMyTrip Gift Cards - Browse, Select and Purchase

  Background:
    Given open the browser
    And load the application URL
    And click on Cabs menu
    And select Outstation trip type
    And user enters valid trip details
    And click on Search button
    And user clicks on the More menu from the results page
    And user selects Gift Cards from the More menu
    And user should be navigated to the Gift Cards page

  Scenario: Verify all occasion categories are displayed on Gift Cards page
    Then all occasion categories should be displayed

  Scenario: Select an occasion gift card
    When user selects an occasion category
    And user selects a gift card
    Then the gift card detail page should be displayed

  Scenario: Select gift card amount and enter sender details
    When user selects an occasion category
    And user selects a gift card
    And user selects the gift card amount
    And user enters sender name
    And user enters sender email
    And user enters sender mobile number
