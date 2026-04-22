Feature:Booking HP for the vacation 
  
  @HP
 Scenario Outline: Book for the HP with invalid details
  Given User launches & navigates to HP
  When User searches HP activities as "Chennai" "Goa" "Thu Apr 30 2026"
  And User filters a package and then select as "Goa" "With" "Honeymoon"
  Then User proceeds to Review page
  When user enter Contact Info "<email>" "<mobileCode>" "<mobile>" "<gstState>" 
  Then Payment should be proceed  
  Examples:
  | testName   | email                | mobileCode | mobile     | gstState   |
  | ValidUser1 | john.doe@email.com   | +91        | 9801238910 | Kerala     |
#  | ValidUser2 | jane.smith@email.com | +44        | 7712345678 | Karnataka  |
  
  
 @HP
 Scenario: Book for the HP with valid details
  Given User launches & navigates to HP
  When User searches HP activities as "Chennai" "Goa" "Thu Apr 30 2026"
  And User filters a package and then select as "Goa" "With" "Honeymoon"
  Then User proceeds to Review page
  When User adds traveller details
  And user enter Traveller Contact :
    | email                | mobileCode | mobile     | gstState   |
    | john.doe@email.com   | +91        | 9801238910 | Kerala     |
 #   | jane.smith@email.com | +44        | 7712345678 | Karnataka  |
 Then Payment should be proceed