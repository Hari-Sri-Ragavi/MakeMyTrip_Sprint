@Flight
Feature: Flight Search, Booking and Status Tracker on MakeMyTrip

  Background:
    Given the user is logged in and on the MakeMyTrip home page

  @Positive @High @TC-01
  Scenario: Search flights with valid source and destination using Excel data
    When the user clicks on "Flights"
    And the user enters source as "<src>"
    And the user enters destination as "<dest>"
    And the user selects a valid travel date
    And the user clicks on "Search"
    
    Examples:
    
      | src      | dest        |
      | Mumbai   | Chennai     |
      | Pune     | Salem       |