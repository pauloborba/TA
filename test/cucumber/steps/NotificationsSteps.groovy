package steps

import pages.ShowNotificationsPage
import ta.EvaluationCriterion
import ta.Notification
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Controller Scenario (happy path)
//Scenario: Registering a grade that requests a notification

Given(~'^that the system has a student named "([^"]*)" with login "([^"]*)" registered$') { String name, login ->
	EvaluateStudentTestDataAndOperations.createStudent(login, name)
	savedStudent = Student.findByLogin(login)
	assert savedStudent != null
}
And(~'^that the system has evaluation criteria named "([^"]*)", "([^"]*)", and "([^"]*)" registered$') { String criteria_name1, criteria_name2, criteria_name3 ->
	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria_name1)
	savedCriteria1 = EvaluationCriterion.findByName(criteria_name1)
	assert savedCriteria1 != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria_name2)
	savedCriteria2 = EvaluationCriterion.findByName(criteria_name2)
	assert savedCriteria2 != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria_name3)
	savedCriteria3 = EvaluationCriterion.findByName(criteria_name3)
	assert savedCriteria3 != null
}
And(~'^that "([^"]*)" only has a MANA registered as a grade for the "([^"]*)" and "([^"]*)" criteria$') { String name, criteria1, criteria2 ->
	//TODO: add "MANA" grade to criteria 1 and 2 and assert both
}
When(~'^I register MANA as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String name, criteria3 ->
	//TODO: add "MANA" grade to criteira3
 	def newNotification = NotificationsTestDataAndOperations.createNotification(savedStudent, savedCriteria1, savedCriteria2, savedCriteria3)
	assert newNotification != null
}
Then(~'^the system stores a low performance notification$') {  ->
	notification = Notification.findByStudent(savedStudent)
	assert notification != null
}

///////////////////////////////////////////
/*
//Controller Scenario (sad path)
//Scenario: Registering a grade that does not request a notification

Given(~'^that the system has a student named "([^"]*)" with login "([^"]*)" registered$') { String name, login ->
	EvaluateStudentTestDataAndOperations.createStudent(login, name)
	assert Student.findByNameAndLogin(name, login) != null
}
And(~'^that the system has evaluation criteria named "([^"]*)", "([^"]*)", and "([^"]*)" registered$') { String criteria1, criteria2, criteria3 ->
	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria1)
	assert EvaluationCriterion.findByName(criteria1) != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria2)
	assert EvaluationCriterion.findByName(criteria2) != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria3)
	assert EvaluationCriterion.findByName(criteria3) != null
}
And(~'^that "([^"]*)" only has a MANA registered as a grade for the "([^"]*)" and "([^"]*)" criteria$') { String name, criteria1, criteria2 ->
	//TODO: add "MANA" grade to criteria 1 and 2 and assert both

	studentName = name
	savedCriteria1 = criteria1
	savedCriteria2 = criteria2
}
When(~'^I register MA as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String name, criteria3 ->
	//TODO: add "MA" grade to criteira3
}
Then(~'^the system does not store a low performance notification$') { ->
	//TODO: assert notification not found
	assert Notification.findByStudent(studentName) == null
}
*/
///////////////////////////////////////////
/*
//GUI Scenario (happy path)
//Scenario: Requesting notifications with at least one stored notification
Given(~'^that I am on the Notifications Page$') { ->
	to ShowNotificationsPage
	at ShowNotificationsPage
}
And(~'^there is at least one registered notification$') { ->
	assert Notification.count > 0
}
When(~'^I select "Read Notifications$') { ->
	page.selectReadNotifications()
}
Then(~'^I can see all notifications$') { ->
	//TODO: check shown notifications
}
*/
///////////////////////////////////////////

//GUI Scenario (sad path)
//Scenario: Requesting notifications with no stored notifications
Given(~'^that I am on the Notifications Page$') { ->
	to ShowNotificationsPage
	at ShowNotificationsPage
}
And(~'^there is no registered notifications$') { ->
	assert Notification.count == 0
}
When(~'^I select "Read Notifications"$') { ->
	page.selectReadNotifications()
}
Then(~'^I can see "There are no new notifications"$') { ->
	assert page.readFlashMessage() != null
}

