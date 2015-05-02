import pages.*
import ta.UEvaluation

/*
Given I am on Register evaluation page
When I fill in the field "title" with "Git evaluation"
And I fill in the field "question" "1" with "How does 'git push' works?"
And I fill in the field "alternative" "1" with "Sends a file to cloud repositorie"
And I fill in the field "alternative" "2" with "gets a file from cloud repositorie"
And I press "Register evaluation" button
Then I should see the message "Git evaluation registered"
*/

//Given I am on Register evaluation page
Given (~'^I am on Register evaluation page$') {
	->
	to RegisterEvaluationPage
	at RegisterEvaluationPage

}

//When I fill in the field "title" with "Git evaluation"
When (~'^I fill in the field "([^"]*)" with "([^"]*)"$') {
	String field, text ->

	at RegisterEvaluationPage
	page.fillData(field, text)
}

//And I fill in the field "question" "1" with "How does 'git push' works?"
//And I fill in the field "alternative" "1" with "Sends a file to cloud repositorie"
//And I fill in the field "alternative" "2" with "gets a file from cloud repositorie"
And (~'^I fill in the field "([^"]*)" "([9-0])" with "([^"]*)"$') {
	String field, int fieldIndex, String fieldData ->

	at RegisterEvaluationPage
	page.fillData(field, fieldIndex, fieldData)
}

//And I press "Register" button
And (~'^I press "([^"]*)" button$') {
	String button ->

	at RegisterEvaluationPage
	page.click(button)
}

//Then I should see the message "Git evaluation registered"
Then (~'^I should see the message "([^"]*)"$') {
	String messageText ->

	at RegisterEvaluationPage
	//def messageBoxText = page.getElementTextById('messageBoxText')
	def messageBoxText = $('#messageBoxText')
	assert messageBoxText.Equals(messageText)
}

/*
Given the system has no evaluation entitled "Git evaluation" stored
When I create an evaluation entitled "Git evaluation"
Then the evaluation "Git evaluation" should be stored in the system
*/

//Given the system has no evaluation entitled "Git evaluation" stored
Given (~'^the system has no evaluation entitled "([^"]*)" stored$') {
	String evaluationTitle ->

	def evaluation = UEvaluation.getByTitle(evaluationTitle)
	assert evaluation == null
}

//When I create an evaluation entitled "Git evaluation"
When (~'^I create an evaluation entitled "([^"]*)"$') {
	String evaluationTitle ->

	UEvaluation.builder.createEvaluation()

	UEvaluation.builder.setEvaluationTitle(evaluationTitle)

	def evaluation = UEvaluation.builder.getEvaluation()

	UEvaluation.saveEvaluation(evaluation)
}

//Then the evaluation "Git evaluation" should be stored in the system
Then (the evaluation "([^"]*)" should be stored in the system) {
	String evaluationTitle ->

	def evaluation = UEvaluation.getByTitle(evaluationTitle)
	assert evaluation.title == evaluationTitle
}