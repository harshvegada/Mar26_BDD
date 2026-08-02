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
#    And user open menu for restaurant "Coffee & More"
#    And user order "12" entity of "Cappuccino"
#    And user click on button text contains "Proceed to Checkout"
#    And user enter "Flat 123456" in "Delivery address" field
#    And user enter "8905714840" in "Contact mobile" field
#    And user click on button text contains "Continue to Payment"
#    And user click on checkbox having label as "I’m not a robot — confirm before paying"
#    And user enter "harsh@okhdfc" in "UPI ID" field
#    And user click on button text contains "Place Order"
#    Then user verify "Order placed!" text should be displayed
#    Then user verify "Your order from Coffee & More is confirmed." text should be displayed


