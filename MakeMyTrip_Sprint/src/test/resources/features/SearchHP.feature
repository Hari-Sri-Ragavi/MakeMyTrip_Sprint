Feature: Holiday Package Search
# Scenario: Search for HP with valid details
# When Click on HP
# And Enter ToCity
# And Enter Rooms&Guests

  # Given Open the browser
  # And Navigate to Application
  # And Enter FromCity
  # And Select DepartureDate
  # Then Click on Search
  # And Verify HP HomePage
  
  
  #Scenario: Apply filters and select HoneyMoon package without flight
   # Given Open the browser and Navigate to Application
    #When Enter search details in HP
    #And Click on Search button
    #Then User is on filter page
   # When Apply City filter
    #And Apply Flight filter
    #And Apply Theme filter
 #   And Apply Package filter
#    Then Click on required package
  #  And Select Package flight option
   # And Verify package details page


 # Scenario: View and edit Activity Info
 #  Given User launches Holiday Package application
  # When User searches holiday package with valid details
 #   And User applies all required filters
  #  And User selects required package
   # Then User verifies package details page
#    And User closes the advertisement popup
 #   And User clicks on Skip option
  #  When User clicks on Change Restaurant
   # And User updates the restaurant details
 #   And User clicks on Update button
  #  Then User proceeds to payment page
  


  Scenario: Add Traveller for the HP
    Given User launches HP application
    When User searches holiday package with valid details
    And User applies filters and selects required package
    And User handles activity info popups
    And User updates restaurant details
    Then User proceeds to payment page
    