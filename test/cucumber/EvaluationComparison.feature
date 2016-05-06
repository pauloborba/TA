Feature: Evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


#GUI


#Success
  @ehammo
Scenario: table is seen with success
Given I am at the StudentPage
And There is a student with the login "bw" and name "Bruce Wayne"
And a criterion with name "C1"
And the student with login "bw" has the grade "MA" in his evaluation in the criteria "C1"
And the student with login "bw" appear in the list of student that sent their auto-Evaluation, with "MA" in the criteria "C1"
When I choose to compare the grades of the student with the login "bw"
Then I can see a table with both student with login "bw" and the professor Evaluations being put, in each criterion, side by side in the screen.
And in the criterion "C1" the Auto Evaluation grade is "MA" and the Final grade is "MA"

#Failure
@ehammo
Scenario:  table is not seen with success
Given I am at the StudentPage
And There is a student with the login "sk" and name "Selina Kyle"
And a criterion with name "C1"
And the student with login "sk" has the grade "MA" in his evaluation in the criteria "C1"
And the student with login "sk" do not appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "sk"
Then I should stay in the Student page
And an Error message should appear

#Controller

#Success
  @ehammo
Scenario: The system return a table with success
Given There is a student with the login "dp" and name "Diana Prince" is registered in the system
And a criterion with name "C1" is registered in the system
And The Auto-Evaluation of the student with login "dp" in the criterion with name "C1" is registered in the system
When There is a request of the Evaluation and Auto-evaluation comparison of student with the login "dp"
Then The system is not altered

#Failure
  @ehammo
Scenario: The system do not return a table with success
Given There is a student with the login "ac" and name "Arthur Curry" is registered in the system
And a criterion with name "C1" is registered in the system
And The Auto-Evaluation of the student with login "ac" is not registered in the system in no criterion
When There is a request of the Evaluation and Auto-evaluation comparison of student with the login "ac"
Then The system is not altered
And The system returns an error message

#interation 2

  #gui

  #Sucess
@ehammo
  Scenario: Color changed with success
    Given I am at the StudentPage
    And There is a student with the login "ba" and name "Barry Allen"
    And a criterion with name "C1"
    And the student with login "ba" has the grade "MANA" in his evaluation in the criteria "C1"
    And the student with login "ba" appear in the list of student that sent their auto-Evaluation, with "MA" in the criteria "C1"
    When I choose to compare the grades of the student with the login "ba"
    Then I can see a table with both student with login "ba" and the professor Evaluations being put, in each criterion, side by side in the screen.
    And in the criterion "C1" the Auto Evaluation grade is "MA" and the Final grade is "MANA"
    And Since the grades are different in the criterion "C1" then the color of them will be both red

  @ehammo
  Scenario: Color did not changed with success
    Given I am at the StudentPage
    And There is a student with the login "jj" and name "John Jones"
    And a criterion with name "C1"
    And the student with login "jj" has the grade "MANA" in his evaluation in the criteria "C1"
    And the student with login "jj" appear in the list of student that sent their auto-Evaluation, with "MANA" in the criteria "C1"
    When I choose to compare the grades of the student with the login "jj"
    Then I can see a table with both student with login "jj" and the professor Evaluations being put, in each criterion, side by side in the screen.
    And in the criterion "C1" the Auto Evaluation grade is "MANA" and the Final grade is "MANA"
    And Since the grades are equal in the criterion "C1" then the color of them will be both black

  @ehammo
  Scenario: Close table with success
    Given I am at the StudentPage
    And There is a student with the login "oq" and name "Oliver Queen"
    And a criterion with name "C1"
    And the student with login "oq" has the grade "MANA" in his evaluation in the criteria "C1"
    And the student with login "oq" appear in the list of student that sent their auto-Evaluation, with "MANA" in the criteria "C1"
    And I chose to compare the grades of the student with the login "oq"
    And I saw a table with both student with login "oq" and the professor Evaluations being put, in each criterion, side by side in the screen.
    And in the criterion "C1" the Auto Evaluation grade is "MANA" and the Final grade is "MANA"
    When I click in the "X" button
    Then The table with both student with login "oq" and the professor Evaluations is closed