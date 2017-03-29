#Giovanni Barros

Feature: Import concepts from spreadsheet
  As a teacher
  I want to import concepts from spreadsheets
  So that my grades are easily recorded on the system

#Controller Scenario
  Scenario: Importing valid spreadsheet
    Given the spreadsheet is on valid format
    When I import it�s data
    Then update system data accordingly

#Controller Scenario
  Scenario: Importing invalid spreadsheet
    Given the spreadsheet is not on valid format
    When I try to import it�s data
    Then do not update system data accordingly

#GUI Scenario
  Scenario: Importing valid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import a spreadsheet
    And the spreadsheet is on valid format
    Then the Concepts page displays new data accordingly

#GUI Scenario
  Scenario: Importing valid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import a spreadsheet
    And the spreadsheet is not on valid format
    Then display error message