Feature: E-Commerce Successful Purchase Flow

  Scenario: User should be able to buy a product successfully
    Given User navigates to the login page
    When User logs in with valid credentials
    And User adds "Sauce Labs Backpack" to the cart
    And User clicks on the shopping cart icon
    And User clicks the checkout button
    And User fills checkout information fields
    And User clicks the finish button
    Then User should see the order confirmation message "Thank you for your order!"



    Scenario: User should not be able to login with invalid credentials
      Given User navigates to the login page
      When User logs in with invalid credentials "wrong_user" and "wrong_password"
      Then User should see the error message "Epic sadface: Username and password do not match any user in this service"
