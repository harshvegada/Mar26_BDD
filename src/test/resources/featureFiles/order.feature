@order
Feature: Order Placement

  @HC-001
  Scenario Outline: Customer should be able to place order successfully
    When user enter "QJC89CQZPQ" in "Student ID" field
    And user enter "DKYDDWKY" in "Access Code" field
    And user click on "Continue" button
    And user choose "Food Application" application
    And user login with "customer" credentials
    And user click on "Sign in to Technocredits Food" button

#    And user login to "Food Application" application with "customer" credentials


    And user search and select "<restaurantName>" restaurant
    And user order "<quantity>" quantity of "<foodItem>"
    And user click on button text contains "Proceed to Checkout"
    And user enter "<address>" in "Delivery address" field
    And user enter "<mobileNumber>" in "Contact mobile" field
    And user click on button text contains "Continue to Payment"
    And user make payment using "<paymentMethod>" payment method
    And user click on checkbox having label as "I’m not a robot — confirm before paying"
    And user click on button text contains "Place Order"
    Then user verify "Order placed!" text should be displayed

    Examples:
      | restaurantName        | quantity | foodItem      | address | mobileNumber | paymentMethod |
      | MAKAIRA KITCHEN & BAR | 1        | Dal Tadaka    | 45 ICON | 8905714840   | Net Banking   |
#      | Balance Brew Cafe     | 1        | Avocado Toast | 45 ICON | 8905714840   | UPI           |
#      | Starbucks Cafe        | 1        | Fries         | 45 ICON | 8905714840   | Card          |