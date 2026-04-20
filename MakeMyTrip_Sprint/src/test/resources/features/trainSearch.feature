Feature: Train Search, Results and Filtering Functionality

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
| Mumbai    | Pune|

  Scenario: Verify train results are displayed and filters work correctly

    Given the user accesses the train reservation section
    When the user provides departure station details
    And the user provides arrival station details
    And the user chooses a journey schedule date
    And the user picks a preferred coach category
    And the user initiates the train lookup
    Then the available train options should be listed

    When the user sets an arrival timing filter
    And the user sets a departure timing filter
    And the user applies a train type preference
    Then only trains matching the selected filters should remain visible

    When the user selects the first train from the filtered list
    Then the train information and booking continuation page should open

 