Feature: Low student performance notifications
	As a teacher
	I want to check for notifications on which students have scored at least 3 low grades,
		each with the name of a student and a list of the criteria in which he scored low grades.
	So that I can better assess my class' performance and to know which students need more attention.

#Controller Scenario (happy path)
  @imvm
Scenario: Registering a grade that requests a notification
	Given that the system has a student named "Nicolla Henrique" with login "nhps" registered
	And that the system has evaluation criteria named "Project Management", "Change Management", and "Team Management" registered
	And that "nhps" only has a MANA registered as a grade for the "Project Management" and "Change Management" criteria
	When I register MANA as the grade for "nhps" for the "Team Management" criteria
  	Then the system stores a low performance notification for "nhps"

#Controller Scenario (sad path)
  @imvm
  @ignore
Scenario: Registering a grade that does not request a notification
	Given that the system has a student named "Alberto Robson" with login "nhps" registered
	And that the system has evaluation criteria named "Project Management", "Change Management", and "Team Management" registered
	And that "armr" only has a MANA registered as a grade for the "Project Management" and "Change Management" criteria
	When I register MA as the grade for "armr" for the "Team Management" criteria
  	Then the system does not store a low performance notification for "nhps"

#GUI Scenario (happy path)
  @imvm
  @ignore
Scenario: Requesting notifications with at least one stored notification
  	Given that I am on the Notifications Page
	And there is at least one registered notification
	When I select "Read Notifications"
  	Then I can see all notifications

#GUI Scenario (sad path)
  @imvm
  @ignore
Scenario: Requesting notifications with no stored notifications
  	Given that I am on the Notifications Page
	And there is no registered notifications
	When I select "Read Notifications"
  	Then I can see "There are no new notifications"

