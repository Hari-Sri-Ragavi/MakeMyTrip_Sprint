@FlightsModule
Feature:Flight Search, Booking and Status Tracker on MakeMyTrip
 @Positive @TS-03
  Scenario: Choose airline from search results
    When the user clicks on "Flights"
    And the user enters source as "Chennai"
    And the user enters destination as "Hyderabad"
    And the user selects a valid travel date
    And the user clicks on "Search"
    And the user selects a specific airline from the search results
    Then the user should see filtered results for that airline

  @Positive @TS-04
  Scenario: View price and book the flight
    When the user clicks on "Flights"
    And the user enters source as "Chennai"
    And the user enters destination as "Hyderabad"
    And the user selects a valid travel date
    And the user clicks on "Search"
    And the user selects a specific airline from the search results
    And the user views the price details for the selected flight
    And the user clicks on "Book Now" button
    Then the user should be navigated to the review booking page