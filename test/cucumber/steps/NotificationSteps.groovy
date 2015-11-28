package steps

import pages.NotificationPage
import ta.EvaluationCriterion
import ta.Notification
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Controller Scenarios
Given(~'^that the system has a student named "([^"]*)" with login "([^"]*)" registered$') { String name, String login ->
	EvaluateStudentTestDataAndOperations.createStudent(login, name)
	assert Student.findByLogin(login) != null
}
And(~'^that the system has evaluation criteria named "([^"]*)", "([^"]*)", and "([^"]*)" registered$') { String criteria1, String criteria2, String criteria3 ->
	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria1)
	assert EvaluationCriterion.findByName(criteria1) != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria2)
	assert EvaluationCriterion.findByName(criteria2) != null

	EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria3)
	assert EvaluationCriterion.findByName(criteria3) != null
}
And(~'^that "([^"]*)" only has a MANA registered as a grade for the "([^"]*)" and "([^"]*)" criteria$') { String login, String criteria1, String criteria2 ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria1, "MANA")
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria2, "MANA")

	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria2, "MANA")
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria2, "MANA")
}
//Scenario: Registering a grade that requests a notification
When(~'^I register MANA as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String login, String criteria3 ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria3, "MANA")
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria3, "MANA")

	def newNotification = NotificationsTestDataAndOperations.createNotification(login)
	assert newNotification != null
}
Then(~'^the system stores a low performance notification$') {  ->
	assert Notification.findByLogin(login) != null
}

//Controller Scenario (sad path)
//Scenario: Registering a grade that does not request a notification
When(~'^I register MA as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String login, String criteria3 ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria3, "MANA")
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria3, "MANA")
}
Then(~'^the system does not store a low performance notification$') { ->
	//TODO: assert notification not found
	assert Notification.findByStudent(studentName) == null
}

//GUI Scenarios
Given(~'^that I am on the Notifications Page$') { ->
	to ShowNotificationsPage
	at ShowNotificationsPage
}
When(~'^I select "Read Notifications$') { ->
	page.selectReadNotifications()
}
//Scenario: Requesting notifications with at least one stored notification
And(~'^there is at least one registered notification$') { ->
	assert Notification.count > 0
}
Then(~'^I can see all notifications$') { ->
	//TODO: check shown notifications
}
//Scenario: Requesting notifications with no stored notifications

And(~'^there is no registered notifications$') { ->
	assert Notification.count == 0
}
Then(~'^I can see "There are no new notifications"$') { ->
	assert page.readFlashMessage() != null
}

