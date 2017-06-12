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
    
  #GUI Scenario
  Scenario: Import students from spreadsheet
    Given I am at the "Add Students" page
    And I want to add students from the "alunos.xls" spreadsheet file
    And The file "alunos.xls" has the student "WELLINGTON FELIX MARTINS FILHO" with user name "wfmf"
    When I add the "alunos.xls" spreadsheet file
    Then I can see the list of all students
    And the student "WELLINGTON FELIX MARTINS" with user name "wfmf" is listed
