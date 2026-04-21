Feature: PNR Status Enquiry

  As a user
  I want to check train PNR status
  So that I can know my booking details and journey status

 Scenario: Verify successful retrieval of PNR status with valid "10-digit PNR number
    Given the user is on the PNR status enquiry page
    When the user enters a valid ten-digit "4756022093" PNR number
    And clicks on the Check Status button
    Then the system should display the PNR status successfully

Scenario: Verify error message for invalid or incorrect PNR number
   Given the user is on the PNR  enquiry page
  When the user enters an invalid or incorrect PNR number
   And clicks on the Check 
   Then the system should display an appropriate error message

  #Scenario: Verify error message for expired or past journey PNR number
    #Given the user is on the PNR status  page
    #When the user enters a PNR number of an expired or past journey
    #And clicks on the Check Status 
   # Then the system should display a past journey or expired PNR error message