Feature: Train Search

Scenario Outline: Verify user can search and select a train with valid details

    Given the user is on the train booking page
    When the user enters source station "<source>"
    And the user enters destination station "<destination>"
    And the user selects a travel date
    And the user selects a travel class
    And the user clicks on the search button
    Then the system should navigate to the booking page

Examples:
| source    | destination |
#| Chennai   | Salem     |
| Chennai   | Coimbatore  |
| Bangalore | Chennai     |
| Shimla    | Shimla|

  