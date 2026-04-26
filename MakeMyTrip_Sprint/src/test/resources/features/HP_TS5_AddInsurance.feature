 Feature:AddOns For the Package HP
 
 @HP
 Scenario: Add Insurance for the HP is added
   Given User launches HP application
   When User searches available HP as "Chennai" "Mumbai" "Thu May 21 2026"
   And User applies filters and selects required package as "Goa"
   And User updates restaurant details
   Then User proceeds to review page
   When click on AddOns 
   And add the insurance
   Then Verify it is added
   
#   @HP
#  Scenario: Verify Insurance for the HP is'nt added
#   Given User launches HP application
#   When User searches available HP as "Chennai" "Goa" "Thu May 21 2026"
#   And User applies filters and selects required package as "Goa"
#   And User updates restaurant details
#   Then User proceeds to review page
#   When click on AddOns 
#   Then Verify it is added