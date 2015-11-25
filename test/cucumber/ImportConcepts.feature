#Giovanni Barros

Feature: Import concepts from spreadsheet
  As a teacher
  I want to import concepts from spreadsheets
  So that my grades are easily recorded on the system

#Controller Scenario (success)
  @ignore
  Scenario: Importing valid spreadsheet (file format and columns)
    Given the spreadsheet "validSheet.xlsx" is on valid file format
    When I try to import its data
    And the spreadsheet contains valid columns
    Then update system data accordingly

#Controller Scenario (failure)
  @gaabs
  Scenario: Importing spreadsheet in invalid file format
    Given the spreadsheet "sheet.csv" is not on valid file format
    When I try to import its data
    Then do not update system data

#Controller Scenario (failure)
  @gaabs
  Scenario: Importing spreadsheet with invalid column
    Given the spreadsheet "invalidColumnSheet.xlsx" is on valid file format
    When I try to import its data
    And the spreadsheet contains invalid columns
    Then do not update system data

#GUI Scenario (success)
  @ignore
  Scenario: Importing valid spreadsheet (file format and columns)
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "validSheet.xlsx"
    And the spreadsheet is on valid format (file format and columns)
    Then an upload confirmation message is displayed

#GUI Scenario (failure)
  @gaabs
  Scenario: Importing spreadsheet in invalid file format
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "sheet.csv"
    And the spreadsheet is not on valid file format
    Then display error message

#GUI Scenario (failure)
  @gaabs
  Scenario: Importing spreadsheet with invalid column
    Given that I am at the Concepts page
    When I select the option to import spreadsheet "invalidColumnSheet.xlsx"
    And the spreadsheet is on valid file format
    And the spreadsheet has invalid columns
    Then display error message

#Controller Scenario
  Scenario: Importing spreadsheet with non registered student
    Given the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"
    When  I import the spreadsheet
    Then the student is registered

#Controller Scenario
  Scenario: Importing spreadsheet with non registered criterion
    Given that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"
    When I import the spreadsheet
    Then the criterion is registered


#possiveis futuros cenários:
#  VERIFICAR correspondencia login nome
#  VERIFICAR nota/conceito válido (MA,MPA,MANA)
