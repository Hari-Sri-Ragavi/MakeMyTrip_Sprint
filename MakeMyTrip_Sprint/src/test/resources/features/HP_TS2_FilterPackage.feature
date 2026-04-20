 Feature: Filter and Select HPs
 Scenario: Apply filters and select HoneyMoon package without flight
 Given Open the browser and Navigate to Application
 When Enter search details in HP as "Chennai" "Dubai" "Thu Apr 23 2026"
 And Click on Search button
 Then User is on filter page
 When Apply City filter as "Dubai"
 And Apply Flight filter as "With"
#And Apply Theme filter
 And Apply Package filter as "Group Tour"
 Then Click on required package
 And Select Package flight option
 And Verify package details page