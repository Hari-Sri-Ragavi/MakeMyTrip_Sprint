Feature:Update the Package Activity
 Scenario: View and edit Activity Info
 Given User launches Holiday Package application
 When User searches holiday package with valid details as "Chennai" "Dubai" "Thu Apr 23 2026"
 And User applies all required filters 
 And User selects required package as "Dubai" "With" "Group Tour"
 Then User closes the advertisement popup
 And User clicks on Skip option
 When User clicks on Change Restaurant as "HOTEL"
 And User updates the restaurant details
 And User clicks on Update button
 Then User proceeds to payment page
 
 Scenario:Remove and Update Activity
 Given User launches Holiday Package application
 When User searches holiday package with valid details as "Chennai" "Dubai" "Thu Apr 23 2026"
 And User applies all required filters 
 And User selects required package as "Dubai" "With" "Group Tour"
 Then User closes the advertisement popup
 And User clicks on Skip option
 When User clicks on Remove Activity and then update 
 Then User proceeds to payment page
 