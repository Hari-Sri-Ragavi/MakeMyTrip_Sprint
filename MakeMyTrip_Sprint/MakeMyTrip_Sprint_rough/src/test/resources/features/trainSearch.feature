Feature: Train Search and Booking

Scenario: Verify user can search and select a train with valid details
Given the user is on the train booking page
When the user enters a valid source station
And the user enters a valid destination station
And the user selects a travel date
And the user selects a travel class
And the user clicks on the search button
Then the system should navigate to the booking page
