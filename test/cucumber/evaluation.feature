Feature: vizualize evaluation
	 As a teacher
	 I want to see evaluation
	 So I can see any details that i want


Scenario: vizualize evaluation
	Given I am on Teaching Assistant Teacher's home page
	When i click on the Vizualize button
	Then I should see the Vizualization Page
	When i put the name of the evaluation
	and click on search
	Then I should see all the evaluations that have the name writted

Scenario: try to see an evaluation that dont exist
	Given I am on Teaching Assistant Teacher's home page
	When i click on the Vizualize button
	Then I should see the Vizualization Page
	When i put the name of the evaluation
	and click on search
	Then I should see an report error informing that there is no evaluation with this name

Scenario: select an evaluation to see it
	Given I am on the vizualization page
	and i searched for a name
	and get the results
	When i click on a evaluation
	Then the evaluation open