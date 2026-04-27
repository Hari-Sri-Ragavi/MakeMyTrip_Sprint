@HotelModule
Feature: Hotel Search

Scenario Outline: Verify hotel booking with multiple data

Given the user is on the hotel booking page
When finds for a hotel using excel sheet
Then the system should navigate to hotel results page