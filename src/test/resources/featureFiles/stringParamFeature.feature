Feature: String Parameter Feature


  @customer
  Scenario: login with customer credentials
    Given user is on login page
    When user enter "customer" credentials
    And user click on sign in button
    Then user should be navigated to find food page

  @owner
  Scenario: login with owner credentials
    Given user is on login page
    When user enter "owner" credentials
    And user click on sign in button
    Then user should be navigated to find food page

  @admin
  Scenario: login with admin credentials
    Given user is on login page
    When user enter "admin" credentials
    And user click on sign in button
    Then user should be navigated to find food page

  @outline
  Scenario Outline: login with multiple credentials
    Given user is on login page
    When user enter "<profiles>" credentials
    And user click on sign in button
    Then user should be navigated to find food page

    Examples:
      | profiles |
      | customer |
      | owner    |
      | admin    |










#    And user enter "QJC89CQZPQ" in placeholder field "e.g. STU001"
#    And user enter "ACSGEJK" in placeholder field "Code shared by your instructor"
#
##  //button[text()='Sign in to Technocredits Food']
#    And user click on "Sign in to Technocredits Food" button text
#    And user click on "Browser restaurants" button text
