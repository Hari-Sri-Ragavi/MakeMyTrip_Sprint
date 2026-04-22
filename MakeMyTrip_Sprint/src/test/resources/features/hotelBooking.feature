Feature: Hotel Booking Flow

Scenario: Complete hotel booking flow

Given the user is on the hotel booking page
When the user searches hotel with city "Goa" checkin "24" checkout "26"
And the user applies price filter "1000-3000"
And the user sorts hotels by "Low to High"
And the user selects first hotel
And the user clicks view this combo
And the user clicks select combo
And the user enters guest details
| FirstName | LastName | Email           | Mobile     |
| Priya     | D        | priya@gmail.com | 9876543210 |
And the user clicks pay now
Then payment page should open