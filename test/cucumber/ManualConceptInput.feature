Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

  #Controller Scenario
  Scenario: Student with no concepts with manual input MA
    Given that the student named "Luke Cage" with a login "lc" is registered in the system
    And the evaluation criterion "Analyze System Requirements" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MA" in the system


 #Controller Scenario
  Scenario: Student with no concepts with manual input MPA
    Given that the student named "Jessica Jones" with a login "jj" is registered in the system
    And the evaluation criterion "Private Investigation" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MPA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MPA" in the system

    #Controller Scenario
  Scenario: Student with no concepts with manual input MANA
    Given that the student named "Matt Murlock" with a login "mm" is registered in the system
    And the evaluation criterion "Refactoring" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MANA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MANA" in the system

#Controller Scenario
  @ignore
  Scenario: Spreadsheet without students and at least one criterion
    Given that the system does not contain students
    And there is a evaluation criterion named "Analyze System Requirements" registered in the system
    Then the system returns a exception

#GUI Scenario
  @ignore
  Scenario: Student with no concepts with manual input MA
    Given that I am on the Student page
    And I can see a student named "Bruce Wayne" with a login "bw"
    And a evaluation criterion named "Administration"
    And I can't see a concept in that criterion
    When I go to the Manual Input Concept Page
    And I choose a new concept "MA" to that student in that criterion
    And I submit the info
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
