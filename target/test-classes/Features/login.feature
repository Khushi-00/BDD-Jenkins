Feature: Login Functionality
#@regression
#Scenario: Verify the login functionality for valid credentials
#Given user is on the login page
#When user enters the username
#And user enters the password
#And user clicks on the login button
#Then user is naqvigated to home page 

#@sanity
#Scenario: Verify the login functionality for Invalid credentials
#Given User is on the login page
#When user enters the invalid username
#And user enters the password
#And user clicks on the login button
#And an error message is displayed

@sanity
Scenario Outline: Verify the login functionality for valid credentials using paramaeter
	Given User is on the login page
	When user enters the "<username>"
	And user enters the "<password>"
	And user clicks on the login button
	Then user is navigated to home page
	
	
	Examples:
	|username| password |
	|Admin| admin123|
	|Admin| admin123|
	|Admin| admin123|
