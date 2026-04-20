@FlightTracker
Feature:MakeMyTrip Flight Tracker

  As a user of MakeMyTrip
  I want to track a flight using the Flight Tracker module
  So that I can know whether my flight is On Time, Delayed, or has an Early Arrival

  Background:
    Given the user is on the MakeMyTrip homepage

  @FlightTracker_Excel
  Scenario: Track all flights with valid flight number
    When the user jumps to the Flights module
    And the user clicks on "Flight Status" option
    And the user tracks all flights using flight number and date from Excel sheet "FlightTracker"
    Then each flight status should be displayed correctly as per Excel

    @FlightTacker_Excel 
    Scenario: Track all flights with invalid flight number
     When the user jumps to the Flights module
    And the user clicks on "Flight Status" option
    And the user tracks all flights using flight number and date from Excel sheet "FlightTracker"
    Then each flight status should be displayed correctly as per Excel