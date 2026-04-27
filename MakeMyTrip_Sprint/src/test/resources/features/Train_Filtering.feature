@TrainModule
Feature: Train Filtering
Scenario: Verify train results are displayed and filters work correctly

    Given the user accesses the train reservation section
    When the user provides departure station details from excel
    And the user provides arrival station details from excel
    And the user chooses a journey schedule date from excel
    And the user picks a preferred coach category from excel
    And the user initiates the train lookup
    Then the available train options should be listed

    When the user sets an arrival timing filter from excel
    And the user sets a departure timing filter from excel
    And the user applies a train type preference from excel
    

    When the user selects the first train from the filtered list
    Then the train information and booking continuation page should open
 