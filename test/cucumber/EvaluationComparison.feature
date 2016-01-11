Feature: Evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


#GUI


#Success

Scenario: table is seen with success
Given I am at the StudentPage
And There is a student with the login "bw" and name "Bruce Wayne"
And a criterion with name "C1"
And the student with login "bw" has the grade "MA" in his evaluation in the criteria "C1"
And the student with login "bw" appear in the list of student that sent their auto-Evaluation, with "MA" in the criteria "C1"
When I choose to compare the grades of the student with the login "bw"
Then I can see a table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.

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
  Scenario: Color changed with sucess
    Given I am at the StudentPage
    And There is a student with the login "ba" and name "Barry Allen"
    And a criterion with name "C1"
    And the student with login "ba" has the grade "MANA" in his evaluation in the criteria "C1"
    And the student with login "ba" appear in the list of student that sent their auto-Evaluation, with "MA" in the criteria "C1"
    When I choose to compare the grades of the student with the login "ba"
    Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
    And Since the grades are different in the criterion "C1" then the color of them will be both red
