import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
import pages.ClassPages.CreateClassPage
import pages.ClassPages.TurmasPage
import steps.ClassTestDataAndOperations


Given(~'^the system has no class named "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.get_Class(id, periodo) == null

}
When(~'^I add a class with ID "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id, periodo)
        cl = ClassTestDataAndOperations.get_Class(id, periodo)
}
Then(~'^the class "([^"]*)" with period "([^"]*)" is properly stored in the system$'){
    String id, periodo ->
        assert ClassTestDataAndOperations.compatibleTo(id, periodo, cl)
}

Given(~'^the system already has a class with ID "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        assert ClassTestDataAndOperations.get_Class(id, periodo) != null
}
When(~'^I add a class with ID "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        ClassTestDataAndOperations.createClass(id, periodo)
        cl = ClassTestDataAndOperations.get_Class(id, periodo)
}
Then(~'^the class "([^"]*)" with period "([^"]*)" is not stored twice in the system$'){
    String id, periodo ->
        assert !ClassTestDataAndOperations.compatibleTo(id, periodo, cl)
}

Given(~'^I am at the Create Class page$'){
    String page ->
        to TurmasPage
        at TurmasPage

}
When(~'^I fill the class details with name "([^"]*)", period "([^"]*)"$') {
    String id, String periodo ->
        at TurmasPage
        page.fillClassDetails(id, periodo)

}
And(~'^I save the class$'){
    ->
    at CreateClassPage
    page.selectCreateClass()
}
Then(~'^I can see a confirmation message$'){
    ->
    at CreateClassPage
}
And(~'^I can see the information for class "([^"]*)", period "([^"]*)" at the Turmas page$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        page.assertClass(id, periodo)
}

Given(~'^the system already has a class with name "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        to CreateClassPage
        at CreateClassPage
        page.fillClassDetails(id, periodo)
}
And(~'^I am at the Create Class page$'){
    String page ->
        to CreateClassPage
        at CreateClassPage
}
When(~'^I fill the class details with name "([^"]*)" and period "([^"]*)"$'){
    String id, String periodo ->
        at CreateClassPage
        page.fillClassDetails(id, periodo)
}
And(~'^I save the class$'){
    ->
    at CreateClassPage
    page.selectCreateClass()
}
Then(~'^I see an error message$'){
    ->
    at CreateClassPage
    page.checkErrors()
}
And(~'^I am taken to the Turmas page where class "([^"]*)", period "([^"]*)" is not listed twice$'){
    String id, String periodo ->
        to TurmasPage
        at TurmasPage
        page.assertNotDuplicateClass(id, periodo)
}