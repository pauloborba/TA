Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

#Controller Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that the spreadsheet contains at least one student and one criterion
    When the user input manually a new concept "MA" with a description "Questão 1 da Prova 1" into a cell
    Then the final criterion concept is updated in the system

#Controller Scenario
  Scenario: Spreadsheet without students or criteria
    Given that the spreadsheet does not contain students or criteria
    Then the system does nothing

#GUI Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that I am on the Manual Concept Input page
    And there are at least one student and one criterion on the spreadsheet
    When I choose a cell
    And I fill it with a new concept "MA" with a description "Questão 1 da Prova 1"
    And I click the button to confirm the operation
    Then the final concept in that criterion is updated

#GUI Scenario
  Scenario: Spreadsheet without students or criteria
    Given that I am on the Manual Concept Input page
    And there are no students or criteria on the spreadsheet
    Then I can not select a cell to input a new concept
    And the page displays a error message.