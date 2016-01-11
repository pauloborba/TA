Feature: Manual Concept Input
  As a professor
  I want to input concepts manually
  So I can input them from written evaluations

  #Controller Scenario
  @psg2
  Scenario: Student with no concepts with manual input MA
    Given that the student named "Luke Cage" with a login "lc" is registered in the system
    And the evaluation criterion "Analyze System Requirements" is also registered in the system
    And the student "lc" doesn't have a concept in the criterion "Analyze System Requirements"
    When the user input manually a new concept "MA" into the student "lc" in the criterion "Analyze System Requirements"
    Then the new concept "MA" of the criterion "Analyze System Requirements" is stored in the student "lc"
    And the final concept of the criterion "Analyze System Requirements" of the student "lc" is updated to "MA" in the system

  @psg2
  Scenario: Student already with concept MANA, MA with manual input MPA
    Given that the student named "Jessica Jones" with a login "jj" is registered in the system
    And the evaluation criterion "Project Management" is also registered in the system
    And the student "jj" already have the concepts "MANA, MA" in the criterion "Project Management"
    When the user input manually a new concept "MPA" into the student "jj" in the criterion "Project Management"
    Then the new concept "MPA" of the criterion "Project Management" is stored in the student "jj"
    And the final concept of the criterion "Project Management" of the student "jj" is updated to "MPA" in the system

  @psg2
  Scenario: Student already with concepts MA, MPA, MPA, MANA and MANA with manual input MA
    Given that the student named "Matt Murlock" with a login "mm" is registered in the system
    And the evaluation criterion "Refactoring" is also registered in the system
    And the student "mm" already have the concepts "MA, MPA, MPA, MANA, MANA" in the criterion "Refactoring"
    When the user input manually a new concept "MA" into the student "mm" in the criterion "Refactoring"
    Then the new concept "MA" of the criterion "Refactoring" is stored in the student "mm"
    And the final concept of the criterion "Refactoring" of the student "mm" is updated to "MPA" in the system

  @psg2
  Scenario: Student already with concepts MA, MANA, MPA with manual input MANA
    Given that the student named "Clint Barton" with a login "cb" is registered in the system
    And the evaluation criterion "Requirements Management" is also registered in the system
    And the student "cb" already have the concepts "MA, MANA, MPA" in the criterion "Requirements Management"
    When the user input manually a new concept "MANA" into the student "cb" in the criterion "Requirements Management"
    Then the new concept "MANA" of the criterion "Requirements Management" is stored in the student "cb"
    And the final concept of the criterion "Requirements Management" of the student "cb" is updated to "MANA" in the system

#GUI Scenario
  @psg2
  Scenario: Student with no concepts with manual input MA
    Given that I am on the Student page
    And I can see a student named "Luke Cage" with a login "lc"
    And I can see a evaluation criterion named "Requirements"
    And I can't see a concept for the student "lc" in the criterion "Requirements"
    When I go to the Manual Input Concept Page
    And I choose a new concept "MA" for the student "lc" in the criterion "Requirements"
    And I submit the info
    Then I can see that the final concept of the criterion "Requirements" for the student "lc" is "MA"

  @psg2
  Scenario: Student already with concept MANA, MA with manual input MPA
    Given that I am on the Student page
    And I can see a student named "Barry Allen" with a login "ba"
    And I can see a evaluation criterion named "Management"
    And I already put the concepts "MA, MPA" for the student "ba" in the criterion "Management"
    And I can see that the concept for the student "ba" in the criterion "Management" is "MA"
    When I go to the Manual Input Concept Page
    And I choose a new concept "MPA" for the student "ba" in the criterion "Management"
    And I submit the info
    Then I can see that the final concept of the criterion "Management" for the student "ba" is "MPA"

  @psg2
  Scenario: Student already with concepts MA, MPA, MPA, MANA and MANA with manual input MA
    Given that I am on the Student page
    And I can see a student named "Oliver Queen" with a login "oq"
    And I can see a evaluation criterion named "Refactoring"
    And I already put the concepts "MA, MPA, MPA, MANA, MANA" for the student "oq" in the criterion "Refactoring"
    And I can see that the concept for the student "oq" in the criterion "Refactoring" is "MANA"
    When I go to the Manual Input Concept Page
    And I choose a new concept "MA" for the student "oq" in the criterion "Refactoring"
    And I submit the info
    Then I can see that the final concept of the criterion "Refactoring" for the student "oq" is "MPA"

  @psg2
  Scenario: Student already with concepts MA, MANA, MPA with manual input MANA
    Given that I am on the Student page
    And I can see a student named "Clint Barton" with a login "cb"
    And I can see a evaluation criterion named "Analyze"
    And I already put the concepts "MA, MANA, MPA" for the student "cb" in the criterion "Analyze"
    And I can see that the concept for the student "cb" in the criterion "Analyze" is "MPA"
    When I go to the Manual Input Concept Page
    And I choose a new concept "MANA" for the student "cb" in the criterion "Analyze"
    And I submit the info
    Then I can see that the final concept of the criterion "Analyze" for the student "cb" is "MANA"

  @psg2
  Scenario: Insertion in two different criterions from the same student
    Given that I am on the Student page
    And I can see a student named "Clint Barton" with a login "cb"
    And I can see a evaluation criterion named "Analyze"
    And I can see a evaluation criterion named "Refactoring"
    And I already put the concepts "MA, MPA, MANA, MANA" for the student "cb" in the criterion "Analyze"
    And I already put the concepts "MA, MPA, MANA, MANA" for the student "cb" in the criterion "Refactoring"
    And I can see that the concept for the student "cb" in the criterion "Analyze" is "MANA"
    And I can see that the concept for the student "cb" in the criterion "Refactoring" is "MANA"
    When I go to the Manual Input Concept Page
    And I choose a new concept "MA" for the student "cb" in the criterion "Analyze"
    And I choose a new concept "MPA" for the student "cb" in the criterion "Refactoring"
    And I submit the info
    Then I can see that the final concept of the criterion "Analyze" for the student "cb" is "MPA"
    And I can see that the final concept of the criterion "Refactoring" for the student "cb" is "MANA"

  @psg2
  Scenario: System without criteria
    Given that I am on the Student page
    And I can see a student named "Clark Kent" with a login "ck"
    And I can't see any evaluation criterion
    When I go to the Manual Input Concept Page
    Then I can see an error message