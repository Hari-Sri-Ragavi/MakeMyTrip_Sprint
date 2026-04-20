
Feature:Flight Search, Booking and Status Tracker on MakeMyTrip

  Background:
    Given the user is logged in and on the MakeMyTrip home page

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
    

    Examples:
      | src    | dest   |
      | Mumbai | Mumbai |

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