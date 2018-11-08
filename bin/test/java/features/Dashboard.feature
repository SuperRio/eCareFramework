Feature: View Dashboard

  Scenario: I want to view my own dashboard.
    Given I the user is logged in
    When I  go to dashboard
    Then I  The user shall view his contracts and subscribers
