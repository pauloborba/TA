#Deyvson Lazaro da Silva

Feature: Modify evaluation
  As a teacher
  I want modify my existing evaluations
  So I can update my evaluations #"So I can test the students better" should be a better reason

  Scenario: modify evaluation
    Given I do not have a evaluation with the name "Build of scenarios"
    And i'm visualising the evaluation "Test of build of scenarios"
    When I rename the evaluation "Test of build of scenarios" for "Build of scenarios"
    Then I gonna be the evaluation "Build of scenarios" in my system
    And not gonna be the evaluation "Test of build of scenarios" in my system

  Scenario: modify evaluation using duplicated name
    Given i'm visualising the evaluation "Test of build of scenarios"
    And I have a evaluation with the name "Build of scenarios"
    When I rename the evaluation "Test of build of scenarios" for "Build of scenarios"
    Then I should see a error message

  Scenario: modify evaluation using blank name
    Given i'm visualising the evaluation "Test of build of scenarios"
    When I rename the evaluation "Test of build of scenarios" for ""
    Then I should see a error message

  Scenario: modify evaluation inserting question
    Given i'm visualising the evaluation "Test of build of scenarios"
    When I insert the question "Scenarios can help us in tests?" in this evaluation with the answer "True"
    Then I gonna be in my system the evaluation "Test of build of scenarios" having the question "Scenarios can help us in tests?" with answer "True"

  Scenario: modify evaluation inserting question without answer
    Given i'm visualising the evaluation "Test of build of scenarios"
    When I set to blank the answer of the question "Scenarios can help us in tests?" in this evaluation
    Then I should see a error message
