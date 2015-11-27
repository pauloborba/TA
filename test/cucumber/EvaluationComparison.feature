Feature: Evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


//GUI

//Success
Scenario: table´s seen with success
Given the student with the login "X" appear in the list of student that sent their auto-Evaluation
When I choose to compare student "X"´s grades
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen
 
//Failure
Scenario:  table isn't seen with success
Given the student "X" don´t appear in the list of student that sent their auto-Evaluation
When I choose to compare student "X" grades
Then I should stay in Student page

//Controller

//Success
Scenario: The system return a table with success
Given Student "X"´s Auto-Evaluation is on the database
When the system requires the Evaluation and Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades

//Failure
Scenario: The system don't return a table with success
Given Student "X"´s Auto-Evaluation isn´t on the database
When the system requires the  Evaluation and Auto-evaluation comparison
Then the system returns an error menssage
