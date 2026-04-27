@FlightsModule
Feature: MakeMyTrip Flight Tracker

Scenario: Track flight with valid flight number
  Given the user is on the MakeMyTrip homepage
  When the user jumps to the Flights module
  And the user clicks on "Flight Status" option
  And the user tracks flight using row 1 from Excel sheet "FlightTracker"
  Then each flight status should be displayed correctly as per Excel

Scenario: Track flight with invalid flight number
  Given the user is on the MakeMyTrip homepage
  When the user jumps to the Flights module
  And the user clicks on "Flight Status" option
  And the user tracks flight using row 2 from Excel sheet "FlightTracker"
  Then each flight status should be displayed correctly as per Excel