Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

#Controller Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that the student named "Luke Cage" with a login "lc" is registered in the system
    And the evaluation criterion "Analyze System Requirements" is also registered in the system
    When the user input manually a new concept "MA" into the student in that criterion
    Then the final criterion concept of that student is updated in the system

#Controller Scenario
  @ignore
  Scenario: Spreadsheet without students and at least one criterion
    Given that the system does not contain students
    And there is a evaluation criterion named "Analyze System Requirements" registered in the system
    Then the system returns a exception

#GUI Scenario
  Scenario: Spreadsheet with at least one student and one criterion
    Given that I am on the Manual Concept Input page
    And I can see a student with login "lc"
    And a evaluation criterion named "Analyze System Requirements"
    When I choose a new concept "MA" to that student in that criterion
    Then I go back to Student List page
    And I can see that the final concept in that criterion is updated for that student

#GUI Scenario
  @ignore
  Scenario: Spreadsheet without students and at least one criterion
    Given that I am on the Manual Concept Input page
    And there are no students
    And there is at least one criterion
    When I try to choose the cell "B2"
    Then the page displays a error message.
