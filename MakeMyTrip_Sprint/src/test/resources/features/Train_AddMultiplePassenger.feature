Feature: Train Add Multiple Passengers

  Scenario: Verify user can complete booking by adding multiple passengers using DataTable

    Given the user launches the train booking portal
    When the user selects the boarding station
    And the user selects the dropping station
    And the user chooses the travel date
    And the user selects the desired coach category
    And the user initiates the train search
    Then the available train options should be shown

    When the user applies an arrival slot filter
    And the user applies a departure slot filter
    And the user chooses the required train type

    When the user selects the first listed train
    And the user navigates to the passenger details screen
    And the user enters multiple passenger details using DataTable
  	| Name    	| Age | Gender    | Berth Preference |
  	| Rita    	| 22  	|Female 	| Lower                 |
  	| Preethi   	| 24  | Female    | Side Lower          |
  	| Ragav 	| 20  | Male       | Upper                 |
    And the user enters a valid IRCTC username
    And the user provides a valid mobile number and valid email
    And the user selects all additional preferences
    Then the passenger details for all travellers should be submitted successfully