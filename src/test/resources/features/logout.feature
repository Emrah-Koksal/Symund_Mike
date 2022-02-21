Feature: Log-out Funcionality

  @regression
  Scenario: User can log out and ends up in login page
    Given User is on the login page
    Given User logs in with valid credentials
    Then the "Dashboard - Symund - QA" should be displayed
    When User clicks on the avatar icon
    When User clicks on the Log Out option from the dropdown menu
    Then the "Symund - QA" should be displayed