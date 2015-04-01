# Bruno Cipriano Minhaqui da Silva - bcms
Feature: Sign up
	As a student
	I want to sign up to the Teaching Assistant system
	So I can login into the system, get evaluations from the teacher and do the self-evaluation
	
	Scenario: sign up
		Given I am on the Teaching Assistant home page
		When I follow "sign up"
		Then I should be on the  Sign up page
		When I fill in "name" with "Bruno Minhaqui"
		And I fill in "login" with "bcms@cin.ufpe.br"
		Then I should see "Student registered"
	
	Scenario: sign up with name field blank
		Given I fill in "login" with "bcms@cin.ufpe.br"
		And no name is informed
		Then I should see "Student not registered"
		
	Scenario: sign up with a login not on Cin's domain
		Given I fill in "name" with "Bruno Minhaqui"
		And I fill in "login" with "minhaqui@gmail.com"
		Then I should see "Student not registered"
	
	Scenario: sign up with duplicated name
		Given I Sign up "Bruno Minhaqui" with login "bcms@cin.ufpe.br"
		And later I Sign up "Bruno Minhaqui" with any login
		Then I should see "Student already exist"
	
	Scenario: sign up with duplicated login
		Given I Sign up "Bruno Minhaqui" with login "bcms@cin.ufpe.br"
		And later I Sign up with any name and login "bcms@cin.ufpe.br" 
		Then I should see "Student already exist"