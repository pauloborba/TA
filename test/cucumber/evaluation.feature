Feature: visualize evaluation
	 As a teacher
	 I want to see an evaluation
	 So I can see any details that i want


Scenario: search evaluation
	Given I am on Teaching Assistant Teacher's home page
  	And add the evaluation "evaluation E1"
  	And add the evaluation "evaluation E2"
	When I select for "evaluations"
  	Then I should see the Visualization Page
	When I search for "evaluation" on the "search" field
	Then I should see all the evaluations that have the name writted

Scenario: try to see an evaluation that dont exist
	Given I am on Teaching Assistant Teacher's home page
	When I search for "evaluation1"
  	Then I should see the visualization Page
	When i put the name of the "evaluation1" on the "search" field
	And click on "search" button
	Then I should see an report error informing that there is no evaluation with this name

Scenario: select an evaluation to see it
  	Given I am on Teaching Assistant Teacher's home page
  	And add the evaluation "evaluation E1"
  	And add the evaluation "evaluation E2"
  	When I search for "evaluation"
	And I Choose "evaluation E1"
	Then "evaluation E1" is open