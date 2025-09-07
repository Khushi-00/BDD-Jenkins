Feature: Demoblaze Website Testing

Scenario: Register a new user
    Given I open Demoblaze website
    When I register with username "testuser" and password "Password123"
    Then I should see a success message

  Scenario: Login with valid credentials
    Given I open Demoblaze website
    When I login with username "testuser" and password "Password123"
    Then I should be logged in successfully

  Scenario: Search for a product and add to cart
    Given I open Demoblaze website
    When I search for "Sony vaio i5"
    And I view product details
    And I add the product to the cart
    Then the product should be added successfully

  Scenario: Complete checkout process
    Given I open Demoblaze website
    And I add "Samsung galaxy s6" to the cart
    When I proceed to checkout
    And I enter payment details
    Then I should see a purchase confirmation
