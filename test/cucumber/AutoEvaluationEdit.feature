Feature : edit auto evaluation
  As a student
  I want to edit my auto evaluation
  So that the professor will be able to know how much I thought I knew of a criterion

  #Controller Scenarios

  Scenario: edit auto evaluation before the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" hasn’t passed yet
    When the student "Clark Wayne" edits the concept of "Requirements"
    Then the new concept of "Requirements" will be saved for "Clark Wayne" in the system


  Scenario: edit auto evaluation after the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" has already passed
    When the student "Clark Wayne" edits the concept of "Requirements"
    Then the new concept of "Requirements" will not be saved in the system

  #GUI Scenarios

  Scenario: edit auto evaluation before the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" hasn’t passed yet
    When  the student "Clark Wayne" chooses the option to edit the concept of "Requirements"
    And chooses the new concept
    Then the new concept of "Requirements" will be saved
    And showed under the name "Requirements"


  Scenario: edit auto evaluation after the time limit has ended
    Given that the time limit for the auto evaluation of the criterion "Requirements" has already passed
    When the student "Clark Wayne" chooses the option to edit the concept of "Requirements"
    Then a warning will appear saying that this can’t be done