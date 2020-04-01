Feature: Opening Page About Otus

  Scenario: Move to About Us page from main page
    Given Im in the main page
    When I click 'About as'
    Then I see the page with title 'About us'