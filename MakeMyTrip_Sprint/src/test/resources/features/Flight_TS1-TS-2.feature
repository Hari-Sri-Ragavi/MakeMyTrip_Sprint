Feature:Flight Search, Booking and Status Tracker on MakeMyTrip


  @Positive @High @TS-01
  Scenario Outline: Search flights with valid source and destination
    When the user clicks on "Flights"
    And the user enters source as "<src>"
    And the user enters destination as "<dest>"
    And the user selects a valid travel date
    And the user clicks on "Search"
    Then the user should see search results for the selected route

    Examples:
      | src    | dest    |
      | Mumbai | Chennai |
      
      @Negative @High @TS-02
  Scenario Outline: Search flights with same source and destination
    When the user clicks on "Flights"
    And the user enters source as "<src>"
    And the user enters destination as "<dest>"
    And the user selects a valid travel date
    Then the system should show an error message
    
     Examples:
      | src    | dest    |
      | Mumbai | Mumbai |