#Thiago Bastos
Feature: Add Group Criterion
  As the teacher
  I want to be able to register new criteria
  So I can evaluate the students with these criteria

#Controller Scenario
  Scenario: Register a group of criteria that does not exist
    Given the criterion "C1" at turma "ESS" and periodo "2016.2" is not on the system
    And the criterion with name "C2" at turma "ESS" and periodo "2016.2" is also not on the system
    When I create the group of criteria "C1;C2" at turma "ESS" and periodo "2016.2"
    Then the criterion "C1" at turma "ESS" and periodo "2016.2" is added to the system
    And the criterion "C2" at turma "ESS" and periodo "2016.2" is also properly added to the system

#GUI Scenario
  Scenario: Register a non-existent group of criteria
    Given I can not see the criterion "C3" at turma "ESS" and periodo "2016.2"
    And I can not see the criterion "C4" at turma "ESS" and periodo "2016.2"
    And I am at the Add Group of Criteria page
    When I fill the field Nome with the name "C3;C4" at turma "ESS" and periodo "2016.2"
    And I finalize the criteria registration
    Then I should see the criterion "C3" available on the criteria list
    And I should see the criterion "C4" available on the criteria list

#Controller Scenario
  Scenario: Register a group of criteria that some of them already exists
    Given the criterion with name "C5" at turma "ESS" and periodo "2016.2" isnt on the system
    And the criterion with name "C9" at turma "ESS" and periodo "2016.2" is on the system
    When I register the group of criteria "C5;C9" at turma "ESS" and periodo "2016.2"
    Then the criterion "C5" at turma "ESS" and periodo "2016.2" is in the system
    And the criterion "C9" at turma "ESS" and periodo "2016.2" is not added to the system

#GUI Scenario
  Scenario: Register a group of criteria that some elements of it already exists
    Given I can not see the criterion "C6" at turma "ESS" and periodo "2016.2"
    And I can see the criterion "C7" at turma "ESS" and periodo "2016.2"
    And I am at the Add Group of Criteria page
    When I fill the field Nome with the name "C6;C7" at turma "ESS" and periodo "2016.2"
    And I finalize the criteria registration
    Then I should see the criterion "C6" available on the criteria list
    And I should see the criterion "C7" only one time available on the criteria list
