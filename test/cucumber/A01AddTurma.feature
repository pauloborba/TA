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
    Given the system already has a class with ID "ESS" and periodo "2016.2"
    When I add a class with ID "ESS" and periodo "2016.2"
    Then the class "ESS" with periodo "2016.2" is not stored twice in the system

#GUI scenario
  Scenario: new class gui
    Given I am at the Create Class page
    When I fill the class details with name "ESS", periodo "2016.2"
    And I save the class
    Then I can see a confirmation message
    And I can see the information for class "ESS", periodo "2016.2" at the Turma Listagem page

#GUI scenario
  Scenario: new class with duplicate ID and periodo gui
    Given the system already has a class with name "ESS" and periodo "2016.2"
    And I am at the Create Class page
    When I fill the class details with name "ESS" and periodo "2016.2"
    And I save the class
    Then I see an error message
