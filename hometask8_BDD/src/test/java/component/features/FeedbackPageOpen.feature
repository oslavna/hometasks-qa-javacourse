Feature: Opening Page Feedback

  Scenario: Move to Feedback page from main page
    Given Im in the main page
    When I click 'Feedback'
    Then I see the page 'Feedback'