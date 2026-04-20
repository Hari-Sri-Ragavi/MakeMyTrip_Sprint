  Feature: Train Add Passengers
  
  Scenario: Verify user can complete passenger information after filtering and selecting a train

    Given the user opens the train booking portal
    When the user chooses a source station
    And the user chooses a destination station
    And the user selects the intended journey date
    And the user selects the preferred coach type
    And the user starts the train search
    Then the matching train services should be displayed

    When the user chooses an arrival time preference
    And the user chooses a departure time preference
    And the user selects a preferred train category
    Then only relevant train options should be shown

    When the user picks the first available train
    And the user moves to the traveller details page
    And the user enters passenger full name
    And the user enters passenger age details
    And the user selects the passenger gender
    And the user provides a valid mobile number
    And the user provides a valid email id
    Then the passenger information should be submitted successfully