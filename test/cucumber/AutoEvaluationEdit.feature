Feature : input auto evaluation
  As a student
  I want to edit my auto evaluation
  So that the professor will be able to know how much I thought I knew of a criterion

  #Controller Scenarios
  @ignore
  Scenario: input auto evaluation
    Given there is the student "Peter Parker" with login "pp"
    And the criterion "Requirements"
    When the user inputs a new concept "MPA" of the criterion "Requirements"
    Then the new concept will be saved in the system


  #GUI Scenarios
  @ignore
  Scenario: input auto evaluation
    Given I am at the student page
    And  I see the student "Peter Parker" with login "pp"
    And the criterion "Requirements"
    When I go to the auto evaluation page
    And I choose a new concept "MPA" for that student in that criterion
    Then I can see the concept for that criterion updated


