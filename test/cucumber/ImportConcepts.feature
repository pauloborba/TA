#Giovanni Barros

Feature: Import concepts from spreadsheet
  As a teacher
  I want to import concepts from spreadsheets
  So that my grades are easily recorded on the system

#Controller Scenario
  @ignore
  Scenario: Importing valid spreadsheet
    Given the spreadsheet "sheet.xlsx" is on valid file format
    When I import its data
    Then update system data accordingly

#Controller Scenario
  @gaabs
  Scenario: Importing invalid spreadsheet
    Given the spreadsheet "sheet.pdf" is not on valid file format
    When I try to import its data
    Then do not update system data

#GUI Scenario
  @ignore
  Scenario: Importing valid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "sheet.xlsx"
    And the spreadsheet is on valid format
    Then the Concepts page displays new data accordingly

#GUI Scenario
  @gaabs
  Scenario: Importing invalid spreadsheet
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "sheet.csv"
    And the spreadsheet is not on valid format
    Then display error message