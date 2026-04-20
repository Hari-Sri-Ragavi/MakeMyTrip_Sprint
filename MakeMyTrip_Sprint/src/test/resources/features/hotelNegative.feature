Feature: Hotel Negative Search

Scenario Outline: Verify hotel search with invalid or empty location
Given the user is on the hotel booking page
When the user enters invalid hotel city "<city>"
And the user clicks invalid hotel search button
Then validation or no results message should display

Examples:
| city       |
| xyzinvalid |
