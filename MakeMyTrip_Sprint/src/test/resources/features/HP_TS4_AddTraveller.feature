Feature: Add Traveller Details  in HP

# @HP
#   Scenario: Traveller for the HolidayPackage with empty fields
#    Given Application is launched
#    When User searches HP for Package ideas as "Chennai" "Goa" "Thu May 21 2026"
#    And User selects a package using filters as "Goa" "With" "Honeymoon"
#    And User edit restaurant details as "HOTEL"
#    Then User proceeds to Booking page
#    When User click add Traveller details
#    Then Verify the Traveller details added
    
  @HP  
   Scenario: Add all the Traveller with valid fields
    Given Application is launched
    When User searches HP for Package ideas as "Chennai" "Kerala" "Thu May 21 2026"
    And User selects a package using filters as "Goa" "With" "Honeymoon"
    And User edit restaurant details as "HOTEL"
    Then User proceeds to Booking page
    When User click add Traveller details
    And User adds traveller details from Excel
    Then Verify the Traveller details added