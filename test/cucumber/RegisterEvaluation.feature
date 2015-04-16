Feature: Register evaluation
	As a teacher
	I want to register evaluation
	So I can see evaluations and send them to students

	# before review
	#Scenario: register evaluation
	#	Given I am on Teaching Assistant Teacher's home page
	#	When I follow "register evaluation"
	#	Then I should be on the Register evaluation page
	#	When I fill in "title" with "Evaluation 1"
	#	And I fill in "item one" with "Question 1"
	#	And I fill in "item one criterion" with "criterion 1"
	#	And I press "Register evaluation"
	#	Then I should see "Evaluation registered"

	# after review
	Scenario: register evaluation
			Given I am on Teaching Assistant Teacher's home page
			When I follow "register evaluation"
			Then I should be on the Register evaluation page
			When I fill in "title" with "Git evaluation"
			And I fill in "question one" with "How does 'git push' do?"
			And I fill in "alternative one" with "Sends a file to cloud repositorie"
			And I fill in "alternative two" with "gets a file from cloud repositorie"
			Then the evaluation should be stored in the system

	# before review
	#Scenario: register evaluation with no items
	#	Given I am on Register evaluation page
	#	When I fill in "title" with "Evaluation 1"
	#	And no items are informed
	#	And I press "Register evaluation"
	#	Then I should see "Evaluation registered"

	# after review
	Scenario: register evaluation with no items
		Given I am on Register evaluation page
		When I fill in "title" with "Git evaluation"
		Then the evaluation should be stored in the system

	# before review
	#Scenario: register duplicate evaluation
	#	Given I am on Register evaluation page
	#	And the evaluation "Evaluation 1" is stored in the system
	#	When I fill "title" with "Evaluation 1"
	#	And I press "Register evaluation"
	#	Then I should see "Evaluation already exist"

	# after review
	Scenario: register duplicate evaluation
		Given I am on Register evaluation page
		And the evaluation "Git evaluation" is stored in the system
		When I fill "title" with "Git evaluation"
		Then no evaluation should be store in the system

	# before review
	#Scenario: register evaluation with no title
	#	Given I am on Register evaluation page
	#	When I press "Register evaluation"
	#	Then I should see "Evaluation's title is required"

	# after review
	Scenario: register evaluation with no title
		Given I am on Register evaluation page
		Then no evaluation should be store in the system