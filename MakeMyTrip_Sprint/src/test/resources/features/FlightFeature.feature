Feature: Flight Search, Booking and Status Tracker on MakeMyTrip

  Background:
    Given the user is logged in and on the MakeMyTrip home page

  @Positive @High @TC-01
  Scenario: Search flights with valid source and destination using Excel data
    When the user clicks on "Flights"
    And the user enters source as "FROM_EXCEL"
    And the user enters destination as "FROM_EXCEL"
    And the user selects a valid travel date
    And the user clicks on "Search"
    Then the user should see search results for the selected route
    When the user selects a specific airline from the search results
    And the user views the price details for the selected flight
    And the user clicks on "Book Now" button
    Then the user should be navigated to the review booking page
    When the user clicks on "Add Baggage" option
    Then the fare summary should show increased total amount reflecting baggage charges

  @FlightTracker_Excel
  Scenario: Track all flights loaded from Excel test data
    Given the user is on the MakeMyTrip homepage
    When the user navigates to the Flights module
    And the user clicks on "Flight Tracker" option
    And the user tracks all flights using flight number and date from Excel sheet "FlightTracker"
    Then each flight status should be displayed correctly as per Excel