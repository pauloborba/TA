Feature: Evaluation -> Auto-evaluation comparison
as a professor
I want to compare my evaluation of the student with the evaluation made by him
so that I can call him if there is any discrepancies.


GUI

Success

Given the student "X" appear in the list of student that sent their auto-Evaluation
When I choose to compare student "X" grades
And select the compare grades option
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
 
Failure

Given the student "X" don't appear in the list of student that sent their auto-Evaluation
When I choose to compare student "X" grades
And select the compare grades option
Then I can see a error message with a go-back button to go to the main page.

Controller

Success

Given Student "X"�s Auto-Evaluation is on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades.

Failure

Given Student "X"�s Auto-Evaluation isn�t on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns an exception.
