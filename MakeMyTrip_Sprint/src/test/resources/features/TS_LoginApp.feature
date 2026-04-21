Feature: Login MakeMyTrip Application

Scenario:Login with valid creditionals
Given User launches & navigates to HP
When user logins through Gmail
And enters Email ID as "sprintmakemytrip@gmail.com"
And enters Password as "qwerty@1234"
Then continue to perform as logged user.