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
	->
	to TeacherHomePage
	at TeacherHomePage

	def evaluation_E1 = UEvaluation.createEvaluation()
	def evaluation_E2 = UEvaluation.createEvaluation()

}
//	When I select for "evaluations"
When (~'^I select for "([^"]*)"$') {
	String button ->	
	at TeacherHomePage
	Page.click(button)
}

//  Then I should see the Visualization Page
Then (~'^I should see the "([^"]*)"$'){
	->
	redirect(view: "VisualisationPage")
}
//	When I search for "evaluation" on the "search" field
When (~'^I search for "([^"]*)" on the "([^"]*)" field$'){
	String title, searchField ->
	at VisualisationPage
	def evaluationList = PicaProsCus.findByTitle(title)

}
//	Then I should see all the evaluations that have the name writted
Then(~'^I should see the all the evaluations that have the name writted$'){
	
}

