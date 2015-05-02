//Feature: visualize evaluation
//	 As a teacher
//	 I want to see an evaluation
//	 So I can see any details that i want
//
//
//Scenario: search evaluation
//	Given I am on Teaching Assistant Teacher's home page
//	And add the evaluation "evaluation E1"
//  And add the evaluation "evaluation E2"
Given (~'^I am on Teaching Assistant Teacher's home page$') {
	
	to HomePage
	at HomePage

	UEvaluation.rippenEvaluation(title: "evaluation E1")
	UEvaluation.rippenEvaluation(title: "evaluation E2")	
	

}

//	When I select for "evaluations"
When (~'^I select for "([^"]*)"$') {
	String button ->	
	at TeacherHomePage
	Page.click(button)
}

//  Then I should see the Visualization Page
Then (~'^I should see the Visualization Page$'){
	at VisualizationPage
}
//	When I search for "evaluation" on the Search field
When (~'^I search for "([^"]*)" on the Search field$'){
	String title ->
	at VisualizationPage
	def l = page.search(title)
}
//	Then I should see all the evaluations that have the name writted
Then(~'^I should see the all the evaluations that have the name writted$'){
	at VisualizationPage
	assert $(#title) != null
}

/*
Scenario: select an evaluation to see it
  	Given I am on Teaching Assistant Teacher's home page
  	And add the evaluation "evaluation E1"
  	And add the evaluation "evaluation E2"
  	When I search for "evaluation"
  	ps: passo já implementado até aqui
	And I Choose "evaluation E1"
	*/
When(~'^I Choose "([^"]*)" on the Search field$'){
	String evaluationTitle ->
	def evaluation = Evaluation.findByTitle(evaluationTitle)
	assert evaluation != null
}
	/*
	Then "evaluation E1" is open
*/
Then(~'^"([^"]*)" is open$'){
	String evaluationTitle ->
	at VisualizationPage
	def o = $('#evaluationTitle')
	assert evaluationTitle.equals(o.title)
}

