@order
Feature: Order Placement

  Background:
    When user enter "QJC89CQZPQ" in "Student ID" field
    And user enter "DKYDDWKY" in "Access Code" field
    And user click on "Continue" button
    And user choose "Food Application" application
    And user login with "customer" credentials
    And user click on "Sign in to Technocredits Food" button

  @HC-001 @home
  Scenario Outline: Customer should be able to place order successfully using Net banking payment methods
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
      | restaurantName        | quantity | foodItem   | address | mobileNumber | paymentMethod |
      | MAKAIRA KITCHEN & BAR | 1        | Dal Tadaka | 45 ICON | 8905714840   | Net Banking   |

  @HC-002 @home
  Scenario Outline: Customer should be able to place order successfully using UPI payment methods
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
      | restaurantName        | quantity | foodItem   | address | mobileNumber | paymentMethod |
      | MAKAIRA KITCHEN & BAR | 1        | Dal Tadaka | 45 ICON | 8905714840   | UPI           |


  @HC-003 @home
  Scenario Outline: Customer should be able to place order successfully using Card payment methods
    And user search and select "<restaurantName>" restaurant

    And user order "<quantity>" quantity of "<foodItem>"
    And user order "<quantity>" quantity of "<foodItem>"
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
      | restaurantName        | quantity | foodItem   | address | mobileNumber | paymentMethod |
      | MAKAIRA KITCHEN & BAR | 1        | Dal Tadaka | 45 ICON | 8905714840   | Card          |


  @HC-004 @dataTable
  Scenario: Customer should be able to place order successfully using Card payment methods
    And user search and select "Coffee & More" restaurant
    # Data-table
    And user place order with below details
      | quantity | foodItem         |
      | 1        | Blueberry Muffin |
      | 2        | Cappuccino       |
    And user enter "<address>" in "Delivery address" field
    And user enter "<mobileNumber>" in "Contact mobile" field
    And user click on button text contains "Continue to Payment"
    And user make payment using "<paymentMethod>" payment method
    And user click on checkbox having label as "I’m not a robot — confirm before paying"

    And user click on button text contains "Place Order"
    Then user verify "Order placed!" text should be displayed


  @page
  Scenario: Verify Edit button on profile is clickable
    And user navigate to profile
    And user wait until page is loaded
    And user click on button text contains "Edit"
