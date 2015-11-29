Feature: Evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


#GUI
#String s = "fieniewfiuwefiuwejiuewjfiu"
#Success
  @ehammo
Scenario: table is seen with success
Given There is a student with the login "rp" and name "Ray Palmer" and a criteria with name "C1" and the student appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "rp"
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen

#Failure
  @ehammo
Scenario:  table is not seen with success
Given The student with the login "sk" and name "Selina Kyle" and a criteria with name "C1" do not appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "sk"
Then I should stay in the Student page

#Controller

#Success
  @ehammo
Scenario: The system return a table with success
Given The Auto-Evaluation of the student with the login "dp" and name "Diana Prince" in the criteria with name "C1" is on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "dp"
Then The system returns a detailed table with both student and the professor grades

#Failure
  @ehammo
Scenario: The system do not return a table with success
Given The Auto-Evaluation of the student with the login "ac" and name "Arthur Curry" in the criteria with name "C1" is not on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "ac"
Then The system returns an error message
