Feature: Login into stackoverflow.com
Existing udemy user should be able to login successfully with valid credentials

Scenario: Login into stackoverflow.com with valid credentails
Given User is on the udemy home page
And clicks on the login button
When user enters valid username and password
And clicks Login
Then user should be successfully logged in 