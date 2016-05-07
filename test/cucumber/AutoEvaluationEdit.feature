Feature: Auto Evaluation Edit
  As a student
  I want to edit my auto evaluation
  So that the professor will be able to know how much I thought I knew of a criterion

  #Controller Scenarios
  @ignore
  Scenario: edit auto evaluation
    Given there is the student "Peter Parker" with login "pp"
    And the criterion "Requirements"
    And the student does not have an auto evaluation for that criterion
    When the user inputs a new concept "MPA" in that criterion
    Then the auto evaluation for that criterion on that student will be updated to "MPA"

  @ignore
  Scenario: edit auto evaluation web
    Given that I am on the Students page
    And there is a student named "Bruce Wayne" with a login "bw"
    And one evaluation criterion named "Administration"
    When I go to the Auto Evaluation Page
    And I choose the student name
    And I choose a new concept "MA" to that student for that criterion
    And I send the info
    Then I go to that student page
    And I can see that the auto evaluation in that criterion for that student is now "MA"
