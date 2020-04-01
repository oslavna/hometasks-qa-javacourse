Feature: Main Page Otus

  Scenario: Opening Main Page from another one via logo
    Given Im in the main page
    Given I click 'About as'
    When I click logo Otus
    Then I see the main page