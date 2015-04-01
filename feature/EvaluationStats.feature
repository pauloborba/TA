#Jorge Vinícius Diniz e Lima - jvdl
Feature: Show statistics about evaluations
	As a teacher
	I want to see the percentage of students who gave the right answer to a question
	So that I can know what percentage understand that subject

Scenario: Show percentage of students who gave right answer
	Given I am at Assistant Teacher's evaluation "number 1" page
	When I click the "Show Statistics" button next to the question "number 2"
	Then I should see the percentage of students who gave the right answer
	And I should see the percentage of students who gave the wrong answer
	And I should see the percentage of students who did not gave any answer

Scenario: Send to student e-mail their statistcs in a evaluation
	Given I am at Assistant Teacher's evaluation "number 1" page
	When I click the "Send Statistics" button
	Then all students should receive a email
	And they will see in this email their statistics for all questions in the evaluation "number 1"