@HotelModule
Feature: Hotel Selection using Filters

Scenario Outline: Verify user can select hotel using filters

Given the user is on the hotel booking page
When the user searches hotel with city "<city>" checkin "<checkin>" checkout "<checkout>"
And the user applies price filter "<priceRange>"
And the user sorts hotels by "<sortType>"
And the user selects a hotel from results
Then the hotel details page should be displayed

Examples:
| city    | checkin | checkout | priceRange | sortType        |
#| Chennai | 20      | 22       | 1000-3000  | Low to High     |
| Goa     | 24      | 26       | 1000-3000  | Low to High     |
#| Mumbai  | 28      | 30       | 1000-3000  | Low to High     |