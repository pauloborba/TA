#Pedro Henrique

Feature: Evaluate the students
  As a teacher
  I want to evaluate my students with respect to various criteria
  So I want to tell him what I think about him on these criteria

#Stakeholder: Paulo Borba
#[16:26:54] Paulo Borba: eu quero avaliar um aluno com rela��o a v�rios criterios
#[16:27:06] Paulo Borba: n�o quero dar uma simples nota a ele
#[16:27:26] Paulo Borba: quero dizer a ele o que eu achei dele com rela��o a v�rios crit�rios

#Controller Scenario
  Scenario: Registering an evaluation criterion that does not exist
    Given the system does not have an evaluation criterion with name "Requirements"
    When I create an evaluation criterion with name "Requirements"
    Then the evaluation criterion with name "Requirements" is properly stored in the system

#Controller Scenario
  Scenario: Registering an evaluation criterion that already exists
    Given the system already has an evaluation criterion named "Requirements"
    When I create an evaluation criterion with name "Requirements"
    Then the evaluation criterion with name "Requirements" was not stored in the system

#Controller Scenario
  Scenario: Updating the list of criteria for registered students
    Given the system does not have an evaluation criterion with name "Project management"
    And the student "Peter Parker" with login "pp2" is registered in the system
    When I create an evaluation criterion with name "Project management"
    Then the system evaluates "Peter Parker" also using the criterion "Project management"


 #GUI Scenarios
  Scenario: Add a new evaluation criterion column to the manual concept input table
    Given that I am on the Student page
    And I can see a student named "Luke Cage" with a login "lc"
    When I create a new evaluation criterion named "Refactoring"
    And I go to the Manual Concept Input Page
    Then I can see a column for the evaluation criterion "Refactoring"

  Scenario: Add a new evaluation criterion to the students list
    Given that I am on the Student page
    And I can see a student named "Luke Cage" with a login "lc"
    When I create a new evaluation criterion named "Requirements"
    And I go to the Student Page
    Then I can see the criterion "Requirements" in the column evaluations for the student "lc"

#Other scenarios gui to do: remove the evaluation criterion