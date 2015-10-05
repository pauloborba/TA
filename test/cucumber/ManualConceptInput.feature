Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

#Controller Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that the spreadsheet is valid
    When a cell is selected
    And a new concept is put on it
    Then the criterion's final concept is updated

#Controller Scenario
  Scenario: Spreadsheet without students or criterions
    Given that the spreadsheet is invalid
    Then the system does nothing

#GUI Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that I am on the spreadsheet page
    When I choose a cell
    And I fill all the information needed
    Then I select the button confirm
    And the final concept in that criterion is updated

#GUI Scenario
  Scenario: Spreadsheet without students or criterions
    Given that I am on the spreadsheet page
    And there are no students or criterions
    Then I can't select a cell to input a new concept