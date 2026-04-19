@Flight
Feature: Flight Search, Booking and Status Tracker on MakeMyTrip

  Background:
    Given the user is logged in and on the MakeMyTrip home page

  @Positive @High @TS-01
  Scenario: Search flights with valid source and destination 
    When the user clicks on "Flights"
    And the user enters source as "<src>"
    And the user enters destination as "<dest>"
    And the user selects a valid travel date
    And the user clicks on "Search"
    
    Examples:
    
      | src      | dest        |
      | Mumbai   | Chennai     |
      
      
      @Negative @High @TS-02
  Scenario: Search flights with valid source and destination 
    When the user clicks on "Flights"
    And the user enters source as "<src>"
    And the user enters destination as "<dest>"
    And the user selects a valid travel date
   
    
    Examples:
    
      | src      | dest        |
      | Mumbai   | Mumbai      |
     
      
      
    @Positive  @TS-03
  Scenario: Choose the airlines and filter option
    When the user clicks on "Flights"
    And the user enters source as "Chennai"
    And the user enters destination as "Hyderabad"
    And the user selects a valid travel date
    And the user clicks on "Search"
    Then the user should see search results for the selected route
    When the user selects a specific airline from the search results
    
    
   @Positive @TS-04
    Scenario: view price and Book the Flight
       When the user clicks on "Flights"
    And the user enters source as "Chennai"
    And the user enters destination as "Hyderabad"
    And the user selects a valid travel date
    And the user clicks on "Search"
    Then the user should see search results for the selected route
    When the user selects a specific airline from the search results
    And the user views the price details for the selected flight
    And the user clicks on "Book Now" button
    Then the user should be navigated to the review booking page
    
    
      