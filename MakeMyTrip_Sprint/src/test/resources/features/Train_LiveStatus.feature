Feature: Live Train Status Validation

  Scenario Outline: Verify user can check live train status successfully

    Given the user navigates to trains section
    And the user opens live train status page
    And the user enters train number "<TrainNo>"
    And the user selects stop "<StopName>"
    And the user selects journey day "<Day>"
    And the user clicks check status button
    Then the train tracker section should be displayed
	Examples:
      | TrainNo | StopName      | Day     |
      | 22154   | Chinna Salem  | Tomorrow   |
      | 12631   | Satur 			| Tomorrow|
      | 12637   | Villupuram    | Yesterday   |
      | 22153 | Chennai Egmore | Today |