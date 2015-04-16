import pages.*

/*
// Given I am on Teaching Assistant Teacher's home page
Given (~'^I am on Teaching Assistant Teachers home page$') {
	->
	to TeacherIndexPage
	at TeacherIndexPage
}

//When I follow "register evaluation"
When (~'^I follow register evaluation button$') {
	->
	at TeacherIndexPage
	page.registerEvaluation()
}
*/

//Given I am on Register evaluation page
Given (~'^I am on Register evaluation page$') {
	->
	to RegisterEvaluationPage
	at RegisterEvaluationPage

}

//When I fill in title with "Git evaluation"
When (~'^I fill in title with "([^"]*)"$') {
	String evaluationTitle ->
	at RegisterEvaluationPage
	def evaluation = URegisterEvaluation.EvaluationBuilder.createEvaluation(evaluationTitle)
	assert evaluation.title == evaluationTitle
}

//And I fill in question one with "How does 'git push' work?"
And (~'^I fill in question one with "([^"]*)"$') {
	String questionDescription ->
	at RegisterEvaluationPage
	def evaluation = URegisterEvaluation.EvaluationBuilder.setEvaluationQuestion(1, questionDescription)
	assert evaluation.questions[1].description == questionDescription

}

//And I fill in "alternative one" with "Sends a file to cloud repositorie"
And (~'^I fill in alternative one with "([^"]*)"$') {
	String alternativeDescription ->
	at RegisterEvaluationPage
	def evaluation = URegisterEvaluation.EvaluationBuilder.getEvaluationQuestion(1).setQuestionAlternative(alternativeDescription)
	assert evaluation.questions[1].alternatives[1].description == alternativeDescription
}

//And I fill in "alternative two" with "gets a file from cloud repositorie"
And (~'^I fill in alternative two with "([^"]*)"$') {
	String alternativeDescription ->
	at RegisterEvaluationPage
	def evaluation = URegisterEvaluation.EvaluationBuilder.getEvaluationQuestion(1).setQuestionAlternative(alternativeDescription)
	assert evaluation.questions[2].alternatives[2].description == alternativeDescription
}

//Then the evaluation "Git evaluation" should be stored in the system
Then (~'^the evaluation "([^"]*))" should be stored in the system$') {
	String evaluationTitle ->
	at RegisterEvaluationPage
	def evaluation = Evaluation.findByTitle(evaluationTitle)
	assert URegisterEvaluation.compatibleTo(evaluation, evaluationTitle)
}