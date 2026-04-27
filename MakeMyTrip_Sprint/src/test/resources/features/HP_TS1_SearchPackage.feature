@HolidayPackageModule
Feature:Holiday Package Search

#@HP
# Scenario:Search for HP with empty fields
# Given Open the browser and then Navigate
# When Click on HP
# Then Click on Search 
# And Verify HP HomePage
 
 @HP
 Scenario: Search for HP with valid details
 Given Open the browser and then Navigate
 When Click on HP
 And Enter FromCity as "Mumbai"
 And Enter ToCity as "Chennai"
 And Select DepartureDate as "Thu May 21 2026"
 And Enter Rooms&Guests
 Then Click on Search
 And Verify HP HomePage