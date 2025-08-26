Feature: Login functionality
 
  Scenario: Successful login with valid credentials

    Given the user is on the login page
    When the user enters username "admin" and password "admin123"
    Then the user should be navigated to the home page
 