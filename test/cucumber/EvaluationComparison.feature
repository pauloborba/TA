Feature: Evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


#GUI

#Success
Scenario: table is seen with success
Given There is a student with the login "ehammo" and name "Eduardo Maia" and a criteria with name "C1" and the student appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "ehammo"
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen
 
#Failure
Scenario:  table is not seen with success
Given The student with the login "X" and name "Y" do not appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "X"
Then I should stay in the Student page

#Controller

#Success
Scenario: The system return a table with success
Given The Auto-Evaluation of the student with the login "ehammo" is on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "X"
Then The system returns a detailed table with both student and the professor grades

#Failure
Scenario: The system do not return a table with success
Given The Auto-Evaluation of the student with the login "X" is not on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "X"
Then The system returns an error message
