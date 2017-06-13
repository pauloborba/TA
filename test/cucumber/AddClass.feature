Feature: Add class
  As a teacher
  I want to add and  remove class, and copy criteria between classes
  So that I can better manage my different classes

#Controller scenario
  Scenario: new class
    Given the system has no class named "ESS" and period "2017.1"
    When I add a class with ID "ESS" and period "2017.1"
    Then the class "ESS" with period "2017.1" is properly stored in the system

#Controller scenario
  Scenario: new class with duplicate ID and periodo
    Given the system already has a class with ID "PLC" and period "2017.1"
    When I add a class with ID "PLC" and period "2016.1"
    Then the class "PLC" with period "2016.1" is not stored twice in the system

#GUI scenario
  Scenario: new class gui
    Given I am at the Create Class page
    When I fill the class details with name "PLC", period "2018.2"
    And I save the class
    Then I can see a confirmation message, and the information for class "PLC", period "2018.2" at the Turma Lista page
    #And I can see the information for class "PLC", period "2018.2" at the Turma Lista page

#GUI scenario
  Scenario: new class with duplicate ID and periodo gui
    Given the system already has a class with name "PLC" and period "2017.2"
    And I am at the Create Class page
    When I fill the class details with name "PLC" and period "2017.2"
    And I save the class
    Then I see an error message