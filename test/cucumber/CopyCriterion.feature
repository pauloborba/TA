Feature: Copy Criterion from existing Class to new Class
  As a teacher
  I want to add a new class and copy criteria between classes
  So that I can better manage my different classes

#Controller scenario
  Scenario: copy class and reuse criterion
    Given the system has a class named "ESS" and periodo "2016.2"
    And the system has no class named "ESS" with periodo "2017.1"
    When I copy the class named "ESS" setting periodo to "2017.1"
    Then the class "ESS" with periodo "2017.1" has previous criterion
    And is properly stored in the system

#GUI scenario
  Scenario: copy class and reuse criterion gui
    Given I am at the Turma List page
    When I choose to copy a class with ID "ESS" and periodo "2016.2"
    And I fill periodo with "2017.1"
    Then I can see a confirmation message
    And I can see a new class named "ESS" with periodo "2017.1" at the Turma List page