@login
Feature: Login Scenarios

  @HC-123 @smoke
  Scenario: login with valid credentials
    Given user is on login page
    When user enter valid username
    And user enter valid password
    And user click on sign in button
    Then user should be navigated to find food page
    And user should see the welcome message

  @HC-128
  Scenario: login with in-valid credentials
    Given user is on login page
    When user enter invalid username
    And user enter invalid password
    And user click on sign in button
    Then user should be navigated to login page

  @HC-125 @smoke @regression
  Scenario: login with empty credentials
    Given user is on login page
    When user click on sign in button
    Then user should be navigated to login page

