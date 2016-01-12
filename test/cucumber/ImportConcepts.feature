#Giovanni Barros

Feature: Import concepts from spreadsheet
  As a teacher
  I want to import concepts from spreadsheets
  So that my grades are easily recorded on the system

  #GUI Scenario (success) 1
  Scenario: Importing valid spreadsheet (file format and columns)
    Given that I am at the Sheet Upload page
    And the spreadsheet "validSheet.xlsx" is on valid file format
    And the spreadsheet "validSheet.xlsx" contains valid columns
    When I select to import the spreadsheet "validSheet.xlsx"
    Then an upload confirmation message is displayed

#GUI Scenario (failure) 2

  Scenario: Importing spreadsheet in invalid file format
    Given that I am at the Sheet Upload page
    And the spreadsheet "sheet.csv" is not on valid file format
    When I select to import the spreadsheet "sheet.csv"
    Then display error message

#GUI Scenario (failure) 3
  Scenario: Importing spreadsheet with invalid column
    Given that I am at the Sheet Upload page
    And the spreadsheet "invalidColumnSheet.xlsx" is on valid file format
    And the spreadsheet "invalidColumnSheet.xlsx" contains invalid columns
    When I select to import the spreadsheet "invalidColumnSheet.xlsx"
    Then display error message

#Controller Scenario (success) 4
  Scenario: Importing valid spreadsheet (file format and columns)
    Given the spreadsheet "validSheet.xlsx" is on valid file format
    And the spreadsheet "validSheet.xlsx" contains valid columns
    When I import the spreadsheet "validSheet.xlsx"
    Then update the system with the data from the spreadsheet "validSheet.xlsx"

#Controller Scenario (failure) 5
  Scenario: Importing spreadsheet in invalid file format
    Given the spreadsheet "sheet.csv" is not on valid file format
    When I import the spreadsheet "sheet.csv"
    Then do not update system data

#Controller Scenario (failure) 6
  Scenario: Importing spreadsheet with invalid column
    Given the spreadsheet "invalidColumnSheet.xlsx" is on valid file format
    And the spreadsheet "invalidColumnSheet.xlsx" contains invalid columns
    When I import the spreadsheet "sheet.csv"
    Then do not update system data

#Controller Scenario 7
  Scenario: Importing spreadsheet with non registered student
    Given the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"
    When  I import the spreadsheet "validSheet.xlsx"
    Then the student named "Alan Turing" with login "at" is registered

#Controller Scenario 8
  Scenario: Importing spreadsheet with non registered criterion
    Given that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"
    When I import the spreadsheet "validSheet.xlsx"
    Then the criterion "grails" is registered


#possiveis futuros cenários:
#  VERIFICAR correspondencia login nome
#  VERIFICAR nota/conceito válido (MA,MPA,MANA)
