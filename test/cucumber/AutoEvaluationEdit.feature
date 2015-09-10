Feature : edit auto evaluation
  As a student
  I want to edit my auto evaluation so that the professor will be able to know how much I thought I knew of a criterion

  #Controller Scenarios


  Scenario: edit auto evaluation before the time limit has ended
    Given that the time limit for the auto evaluation of a criterion hasn’t passed yet
    When a student edits this criterion’s concept
    Then the new concept will be saved in the system


  Scenario: edit auto evaluation after the time limit has ended
    Given that the time limit for the auto evaluation of a criterion has already passed
    When a student edits this criterion’s concept
    Then the new concept will not be saved in the system

  #GUI Scenarios


  Scenario: edit auto evaluation before the time limit has ended
    Given that the time limit for the auto evaluation of a criterion hasn’t passed yet
    When a student chooses the option to edit this criterion’s concept
    And chooses the new concept
    Then the new concept will be saved
    And showed under the criterion’s name


  Scenario: edit auto evaluation after the time limit has ended
    Given that the time limit for the auto evaluation of a criterion has already passed
    When a student chooses the option to edit this criterion’s concept
    Then a warning will appear saying that this can’t be done
