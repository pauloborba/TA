Feature: Add classes
  As a teacher
  I want to add and  remove classes, and copy criteria between classes
  So that I can better manage my different classes

#Controller scenario
  Scenario: new class
    Given the system has no class named "ESS" and semester "2016.2"
    When I add a class with ID "ESS" and semester "2016.2"
    Then the class "ESS" with semester "2016.2" is properly stored in the system

#Controller scenario
  Scenario: new class with duplicate ID and periodo
    Given the system already has a class with ID "GDI" and semester "2016.1"
    When I add a class with ID "GDI" and semester "2016.1"
    Then the class "GDI" with semester "2016.1" is not stored twice in the system

#GUI scenario
  Scenario: new class gui
    Given I am at the Create Class page
    When I fill the class details with name "ESS", semester "2015.2" and save it
    Then I can see the information for class "ESS", semester "2015.2" at the Turma Listagem page

#GUI scenario
  Scenario: new class with duplicate ID and periodo gui
    Given the system already has a class with name "GDI" and semester "2015.1"
    And I am at the Create Class page
    When I fill the class details with name "GDI", semester "2015.1" and save it
    Then I see an error message