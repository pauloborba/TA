Feature: Add students from spreadsheet
  As a teacher
  I want to be able to import students from a spreadsheet file
  So I can add many students at once

  Scenario: Add students from spreadsheet file
    Given I have the file "alunos.xls" which contains the students names and user names
    And the file "alunos.xls" has the student "WELLINGTON FELIX MARTINS FILHO" with cin username "wfmf"
    And the system has the class "ESS 2016-2"
    When I import the file "file.xls" for the "ESS 2016.2" class
    Then the system adds the student "WELLINGTON FELIX MARTINS FILHO" with cin username "wfmf" to the class "ESS 2016-2"

  Scenario: Import a spreadsheet file
    Given I have the class "ESS 2017-1"
    And I am at the "Importar Alunos" page
    And the class "ESS 2017-1" is registered in the system
    When I choose the class "ESS 2017-1" and the file "alunos.xls"
    Then I can see the list of all students
