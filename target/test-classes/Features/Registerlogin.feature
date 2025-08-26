Feature: Register a new user on Guru99

  Scenario: Fill all fields and submit the registration form
    Given User is on the Guru99 registration page
    When User enters registration details:
      | firstName    | John         |
      | lastName     | Doe          |
      | phone        | 9876543210   |
      | email        | john@example.com |
      | address      | 123 Street   |
      | city         | New York     |
      | state        | NY           |
      | postalCode   | 10001        |
      | country      | UNITED STATES |
      | username     | johndoe      |
      | password     | Test@123     |
      | confirmPassword | Test@123  |
    Then User submits the registration form
