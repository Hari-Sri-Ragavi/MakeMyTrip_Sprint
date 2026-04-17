Feature: Hotel Search

Scenario: Verify user can search hotel with valid city
Given the user is on the hotel booking page
When the user enters valid hotel city
And the user clicks hotel search button
Then the system should navigate to hotel results page