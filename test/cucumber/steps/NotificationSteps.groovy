package steps

import pages.NotificationPage
import ta.EvaluationCriterion
import ta.Notification
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Controller Scenarios
Given(~'^that the system has a student named "([^"]*)" with login "([^"]*)" registered$') { String name, login ->
	created = EvaluateStudentTestDataAndOperations.createStudent(login, name)
	exists = Student.findByLogin(login)

	assert created || exists
}
And(~'^that the student with login "([^"]*)" has evaluation criteria named "([^"]*)", "([^"]*)", and "([^"]*)" registered$') { String login, criteria1, criteria2, criteria3 ->
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
When(~'^I register "([^"]*)" as the grade for "([^"]*)" for the "([^"]*)" criteria$') { String concept,login, criteria ->
	EvaluateStudentTestDataAndOperations.updateConcept(login, criteria, concept)
	assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criteria, concept)
}
Then(~'^the system stores a low performance notification for "([^"]*)"$') { String login  ->
	EvaluateStudentTestDataAndOperations.createNotification(login)
	assert Student.findByLogin(login).notification==true
}

//Scenario: Registering a grade that does not request a notification
Then(~'^the system does not store a low performance notification for "([^"]*)"$') { String login ->
	assert Notification.findByLogin(login) == null
}

//GUI Scenarios
Given(~'^that I am on the Notifications Page$') { ->
	to NotificationPage
	at NotificationPage
}
When(~'^I select "Read Notifications$') { ->
	at NotificationPage
	page.selectReadNotifications()
}
//Scenario: Requesting notifications with at least one stored notification
And(~'^there is at least one registered notification$') { ->
	assert Notification.count > 0
}
Then(~'^I can see all notifications$') { ->
	at NotificationPage
	page.update()
}
//Scenario: Requesting notifications with no stored notifications

And(~'^there is no registered notifications$') { ->
	assert Notification.count == 0
}
Then(~'^I can see "There are no new notifications"$') { ->
	assert page.readFlashMessage() != null
}
