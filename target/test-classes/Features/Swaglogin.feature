Feature: SauceDemo Login and Checkout

  Scenario Outline: Login, select product, and checkout
    Given User is on the SauceDemo login page
    When user enters username "<username>" and password "<password>"
    And user clicks the login button
    Then user should be logged in successfully
    When user selects the first product and adds it to cart
    And user goes to cart
    And user clicks checkout
    And user enters first name "<firstName>", last name "<lastName>", postal code "<postalCode>"
    And user clicks continue and finish
    Then order should be placed successfully

    Examples:
      | username           | password   | firstName | lastName | postalCode |
      | standard_user      | secret_sauce | John      | Doe      | 12345      |
      | problem_user       | secret_sauce | Jane      | Smith    | 67890      |
