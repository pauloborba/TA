import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
import pages.ClassPages.CreateClassPage
import pages.ClassPages.TurmasPage
import steps.ClassTestDataAndOperations
import ta.Class
import ta.ClassController

Class c

Given(~'^the system has no class named "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.get_Class(id, periodo) == null

}
When(~'^I add a class with ID "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id, periodo)
        c = ClassTestDataAndOperations.get_Class(id,periodo)
        assert ClassTestDataAndOperations.get_Class(id,periodo) != null
}

Then(~'^the class "([^"]*)" with period "([^"]*)" is properly stored in the system$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.compatibleTo(id, periodo, c)
}

Given(~'^the system already has a class with ID "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id,periodo)
        c = ClassTestDataAndOperations.get_Class(id, periodo)
        assert c != null
}

Then(~'^the class "([^"]*)" with period "([^"]*)" is not stored twice in the system$'){
    String id, periodo ->
        assert ClassTestDataAndOperations.onlyClass(id,periodo)
}

Given(~/^I am at the Create Class page$/){
    ->
        to CreateClassPage
        at CreateClassPage

}

When(~/^I fill the class details with name "([^"]*)", period "([^"]*)"$/) {
    String id, String periodo ->
        at CreateClassPage
        page.fillClassDetails(id, periodo)

}

And(~/^I save the class$/){
    ->
    at CreateClassPage
    page.selectCreateClass()
}
//errado aqui tbm
Then(~/^I can see a confirmation message$/){
    ->
    at CreateClassPage
}

And(~'^I can see the information for class "([^"]*)", period "([^"]*)" at the Turma Lista page$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        assert page.confirmTurma(id,periodo)
}
Given(~'^the system already has a class with name "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        to CreateClassPage
        at CreateClassPage
        page.fillClassDetails(id, periodo)
        page.selectCreateClass()
}
When(~'^I fill the class details with name "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        at CreateClassPage
        page.fillClassDetails(id, periodo)
        page.selectCreateClass()
}
Then(~'^I see an error message$'){
    ->
    at CreateClassPage
    page.checkErrors()
}
//muito errado
And(~'^I am taken to the Turmas page where class "([^"]*)", period "([^"]*)" is not listed twice$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        page.assertNotDuplicateClass(id, periodo)
}