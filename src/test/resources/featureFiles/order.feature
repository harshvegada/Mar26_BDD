@order
Feature: Order Placement

  @HC-001
  Scenario: Customer should be able to place order successfully
    When user enter "QJC89CQZPQ" in "Student ID" field
    And user enter "DKYDDWKY" in "Access Code" field
    And user click on "Continue" button
    And user choose "Food Application" application
    And user login with "customer" credentials
    And user click on "Sign in to Technocredits Food" button
    And user search and select "MAKAIRA KITCHEN & BAR" restaurant
    And user order "12" quantity of "Dal Tadaka"
    And user click on button text contains "Proceed to Checkout"
    And user enter "45 ICON" in "Delivery address" field
    And user enter "8905714840" in "Contact mobile" field
    And user click on button text contains "Continue to Payment"
    And user make payment using "UPI" payment method
    And user click on checkbox having label as "I’m not a robot — confirm before paying"
    And user click on button text contains "Place Order"
    Then user verify "Order placed!" text should be displayed


