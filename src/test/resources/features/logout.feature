@regression  @SYMU-1067
Feature: Log-out Functionality

  Background:
    Given User is on the login page

  @SYMU-1065
  Scenario: User can log out and ends up in login page
    Given User logs in with valid credentials
    Then the "Dashboard - Symund - QA" should be displayed
    When User clicks on the avatar icon
    When User clicks on the Log Out option from the dropdown menu
    Then the "Symund - QA" should be displayed

  @SYMU-1066
  Scenario: User can not go to home page again by clicking step back button after successfully logged out
    Given User logs in with valid credentials
    Then the "Dashboard - Symund - QA" should be displayed
    When User clicks on the avatar icon
    When User clicks on the Log Out option from the dropdown menu
    Then the "Symund - QA" should be displayed
    When User clicks step back button
    Then the "Symund - QA" should be displayed