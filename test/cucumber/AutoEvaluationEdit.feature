Feature : edit auto evaluation
  As a student
  I want to edit my auto evaluation
  So that the professor will be able to know how much I thought I knew of a criterion

  #Controller Scenarios

  Scenario: edit auto evaluation before the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" has not ended yet
    When the user inputs a new concept "MPA" of the criterion "Requirements"
    Then the new concept will be saved in the system


  Scenario: edit auto evaluation after the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" has ended
    Then the system does nothing

  #GUI Scenarios

  Scenario: edit auto evaluation before the time limit has ended
    Given I am at the auto evaluation page
    When  I choose the criterion "Requirements"
    And I put the new concept "MPA"
    And I click the button to confirm
    Then the concept for that criterion is updated


  Scenario: edit auto evaluation after the time limit has ended
    Given I am at the auto evaluation page
    When I choose the criterion "Requirements"
    Then a warning will appear