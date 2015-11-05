#Giovanni Barros

Feature: Import concepts from spreadsheet
  As a teacher
  I want to import concepts from spreadsheets
  So that my grades are easily recorded on the system

#Controller Scenario
  Scenario: Importing valid spreadsheet
    Given the spreadsheet "sheet.csv" is on valid file format
    When I import its data
    Then update system data accordingly

#Controller Scenario
  Scenario: Importing invalid spreadsheet
    Given the spreadsheet "sheet.csv" is not on valid file format
    When I try to import its data
    Then do not update system data

#GUI Scenario
  Scenario: Importing valid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "sheet.csv"
    And the spreadsheet is on valid format
    Then the Concepts page displays new data accordingly

#GUI Scenario
  Scenario: Importing valid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "sheet.csv"
    And the spreadsheet is not on valid format
    Then display error message