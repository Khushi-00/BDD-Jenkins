Feature: Automate Student Registration Form

  Scenario: Fill and submit the registration form
    Given user navigates to the registration page
    When user enters valid details in the form
    And user submits the form
    Then form should be submitted successfully
