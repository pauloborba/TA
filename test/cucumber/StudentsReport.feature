#Victor Augusto Pereira Porciúncula - vapp

Feature: Final Students Report
  As the teacher
  I want to generate the final report of the students
  So that I can see the final grades and status of the students

#GUI Scenario

  Scenario: Row view of the student that pass, pass on final and don't pass
    Given I create the students "Joao", "Caio", "Henrique" of logins "jkd", "caf", "herk" respectively
    And I create the criterions "Patterns", "Feature", "Scenario"
    And I evaluate the criterions "Patterns", "Feature" e "Scenario" of the logins' students "jkd", "caf", "herk" as "MA", "MPA", "MANA", respectively, for each login in each criterion
    When I see the Students Report
    Then The row's color of the logins "jkd", "caf", "herk" will be the colors "green", "yellow", "red" on the Students Report


  Scenario: View of total criterions evaluated
    Given I create the student "Ricardo" of login "rcc"
    And I create the criterions "Patterns", "Feature", "Scenario" and "Refactoring"
    And I evaluate the criterions "Patterns", "Feature", "Scenario" and "Refactoring" of login's student "rcc" to "MA"
    When I check the students report
    Then The column "Total de critérios avaliados" of the login's student "rcc" will be "4"


  Scenario: View of students that passed, passed on finals, failed for non-attendance, failed by score and number of total students
    Given I create the students "Joao", "Caio", "Henrique", "Juliano" of logins "jkd", "caf", "herk", "jqo", respectively
    And I create the criterions "Patterns", "Scenario"
    And I evaluate the criterions "Patterns" and "Scenario" of the logins' students "jkd", "caf", "herk" and "jqo" as "MA", "MPA", "MANA", "MANA" and "MA", "MPA", "MANA", "--", respectively for each login
    When I go to Students Report
    Then The columns' numbers of "Total de aprovados por media", "Total de aprovados na final", "Total de reprovados por falta" ,"Total de reprovados por nota" and "Total de alunos" are going to be equal to "1", "1", "1", "1" and "4", respectively