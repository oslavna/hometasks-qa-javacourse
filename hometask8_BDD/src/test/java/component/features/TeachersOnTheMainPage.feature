Feature: Teacher On The Main Page

  Scenario: Teachers are present on the Main Page
    Given Im in the main page
    Given I click 'About as'
    When I click logo Otus
    Then I see teachers of courses