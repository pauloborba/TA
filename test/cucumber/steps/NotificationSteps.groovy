package steps

import pages.NotificationPage
import ta.EvaluationCriterion
import ta.Notification
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Controller Scenarios
Given(~'^that the system has a student named "([^"]*)" with login "([^"]*)" registered$') { String name, login ->
	assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}
And(~'^that the system has evaluation criteria named "([^"]*)", "([^"]*)", and "([^"]*)" registered$') { String criteria1, criteria2, criteria3 ->
	assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria1)
	assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria2)
	assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criteria3)
}
And(~'^that "([^"]*)" only has a "([^"]*)" registered as a grade for the "([^"]*)" and "([^"]*)" criteria$') { String login, concept, criteria1, criteria2 ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria1, concept)
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria1, concept)

	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria2, concept)
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria2, concept)
}
//Scenario: Registering a grade that requests a notification
When(~'^I register "([^"]*)" as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String login, concept, criteria ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria, concept)
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria, concept)
}
Then(~'^the system stores a low performance notification for "([^"]*)"$') { String login  ->
	assert NotificationsTestDataAndOperations.createNotification(login)
}

//Scenario: Registering a grade that does not request a notification
When(~'^I register "([^"]*)" as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String login, concept, criteria ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria, concept)
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria, concept)
}
Then(~'^the system does not store a low performance notification for "([^"]*)"$') { String login ->
	assert Notification.findByLogin(login) == null
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

