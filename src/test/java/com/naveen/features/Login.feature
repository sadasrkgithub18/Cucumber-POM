@Smoke
Feature: Login validation feature
  As a registered user
  In order to validate login
  I want to login check login validation

  @Login-Valid
  Scenario: Login test with valid credentials
    Given when user is on login page
    When user enters valid credentials
    And when he clicks on login
    Then login should be successful
