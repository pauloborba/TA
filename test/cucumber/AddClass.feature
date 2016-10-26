Feature: Add classes
  As a teacher
  I want to add and  remove classes, and copy criteria between classes
  So that I can better manage my different classes

#Controller scenario
  Scenario: new class
    Given the system has no class named "ESS" and periodo "2016.2"
    When I add a class with ID "ESS" and periodo "2016.2"
    Then the class "ESS" with periodo "2016.2" is properly stored in the system

#Controller scenario
  Scenario: new class with duplicate ID and periodo
    Given the system already has a class with ID "GDI" and periodo "2016.1"
    When I add a class with ID "GDI" and periodo "2016.1"
    Then the class "GDI" with periodo "2016.1" is not stored twice in the system

#GUI scenario
  Scenario: new class
    Given I am at the Create Class page
    When I fill the class details with name "ESS", periodo "2016.2"
    And I save the class
    Then I can see a confirmation message
    And I can see the information for class "ESS", periodo "2016.2" at the "Turmas" page

#GUI scenario
  Scenario: new class with duplicate ID and periodo
    Given the system already has a class with name "GDI" and periodo "2016.1"
    And I am at the Create Class page
    When I fill the class details with name "GDI" and periodo "2016.1"
    And I save the class
    Then I see an error message
    And I am taken to the "Turmas" page where class "GDI", periodo "2016.1" is not listed twice
