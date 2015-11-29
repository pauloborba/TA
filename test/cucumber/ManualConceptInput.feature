Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

  #Controller Scenario
  @ignore
  Scenario: Student with no concepts with manual input MA
    Given that the student named "Luke Cage" with a login "lc" is registered in the system
    And the evaluation criterion "Analyze System Requirements" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MA" in the system


 #Controller Scenario
  @psg2
  Scenario: Student with no concepts with manual input MPA
    Given that the student named "Jessica Jones" with a login "jj" is registered in the system
    And the evaluation criterion "Private Investigation" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MPA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MPA" in the system


#Controller Scenario
  @psg2
  Scenario: Student with no concepts with manual input MANA
    Given that the student named "Matt Murlock" with a login "mm" is registered in the system
    And the evaluation criterion "Refactoring" is also registered in the system
    And the student doesn't have a concept in that criterion
    When the user input manually a new concept "MANA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MANA" in the system

  @psg2
  Scenario: Student already with concepts MA and MPA with manual input MPA
    Given that the student named "Clint Barton" with a login "cb" is registered in the system
    And the evaluation criterion "Archery" is also registered in the system
    And the student already have the concepts "MA" and "MPA" in that criterion
    When the user input manually a new concept "MPA" into the student in that criterion
    Then the new concept of that criterion is stored in the student
    And the final criterion concept of that student is updated to "MPA" in the system

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
    Then I go back to Student page
    And I can see that the final concept in that criterion for that student is now "MA"

  @ignore
  Scenario: Student with no concepts with manual input MPA
    Given that I am on the Student page
    And I can see a student named "Barry Allen" with a login "ba"
    And a evaluation criterion named "Velocity"
    And I can't see a concept in that criterion
    When I go to the Manual Input Concept Page
    And I choose a new concept "MPA" to that student in that criterion
    And I submit the info
    Then I go back to Student page
    And I can see that the final concept in that criterion for that student is now "MPA"

  @ignore
  Scenario: Student with no concepts with manual input MANA
    Given that I am on the Student page
    And I can see a student named "Oliver Queen" with a login "oq"
    And a evaluation criterion named "Survival"
    And I can't see a concept in that criterion
    When I go to the Manual Input Concept Page
    And I choose a new concept "MANA" to that student in that criterion
    And I submit the info
    Then I go back to Student page
    And I can see that the final concept in that criterion for that student is now "MANA"

    @ignore
    Scenario: Student already with concepts MA and MPA with manual input MPA
    Given that I am on the Student page
    And I can see a student named "Clark Kent" with a login "ck"
    And a evaluation criterion named "Journalism"
    And I already put the concepts "MA" and "MPA" for that student in that criterion
    When I go to the Manual Input Concept Page
    And I choose a new concept "MPA" to that student in that criterion
    And I submit the info
    Then I go back to Student page
    And I can see that the final concept in that criterion for that student is now "MPA"

#  @psg2
  @ignore
  Scenario: Error Message
    Given that I am on the Student page
    And I can see a student named "Clark Kent" with a login "ck"
    And I can't see any evaluation criterion
    When I go to the Manual Input Concept Page
    Then I can see an error message
