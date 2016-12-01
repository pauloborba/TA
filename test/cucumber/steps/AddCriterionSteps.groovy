/*
Estes steps são da feature inicial, idealizada antes da iteração de imlementar features.
Portanto, será descartado dos testes finais visto que não faz uso de métodos de controlador que não sejam
Gerados automaticamente.
*/
/**
 * Created by Arthur Lapprand on 03/05/2016.
 */


import pages.CreateCriterionPage
import pages.ShowCriterionPage
import steps.CriterionTestDataAndOperations
import steps.ClassTestDataAndOperations
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import ta.Criterion

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

/*
Feature: Add Criterion
  As the teacher
  I want to be able to register new criteria
  So I can evaluate the students with these criteria
*/

Criterion crit
String tempDesc

/*
#Controller Scenario
Scenario: Register a criterion that does not exist
Given the criterion with name "P1" isn't on the system
When I create the criterion "P1"
Then the criterion "P1" is properly added to the system
*/
Given(~'^the criterion with name "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)" is not on the system$') {
    String desc, String classID, String periodo ->
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        crit = CriterionTestDataAndOperations.getCriterion(desc, t.id.toString())
        assert crit == null
}

When(~'^I create the criterion "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)"$') {
    String desc, String classID, String periodo ->
        CriterionTestDataAndOperations.createCriterion(desc, t.id.toString())
        crit = CriterionTestDataAndOperations.getCriterion(desc, t.id.toString())
        assert crit != null
}

Then(~'^the criterion "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)" is properly added to the system$') {
    String desc, String classID, String periodo ->
        assert CriterionTestDataAndOperations.compatibleTo(desc, crit)
}

/*
#Controller Scenario
Scenario: Register a criterion that already exists
Given the criterion named "P1" already exists on the system
When I create the criterion "P1"
Then system does nothing
*/
Given(~'^the criterion named "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)" already exists on the system$') {
    String desc, String classID, String periodo ->
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        CriterionTestDataAndOperations.createCriterion(desc, t.id.toString())
        c = CriterionTestDataAndOperations.getCriterion(desc, t.id.toString())
        assert c != null
}

When(~'^I create the criterion with description "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)"$') {
    String desc, String classID, String periodo ->
        CriterionTestDataAndOperations.createCriterion(desc, t.id.toString())
}

Then(~'^the system does nothing$') { ->
    assert CriterionTestDataAndOperations.compatibleInCriteria(c.description, t.id.toString())
}

/*
#GUI Scenario
  Scenario: Error when registering a criterion that already exists
    Given I am on the Add Criterion page
    And the criterion "P1" already exists
    When I add the criterion "P1"
    Then I should see a message related to the criterion registration failure
 */
Given(~'^the criterion "([^"]*)" already exists at turma "([^"]*)" and periodo "([^"]*)"$') {
    String desc, String classID, String periodo ->
        to CreateCriterionPage
        at CreateCriterionPage
        page.createCriterion(desc, classID, periodo)
        at ShowCriterionPage
}

And(~'^I am on the Add Criterion page$') { ->
    to CreateCriterionPage
    at CreateCriterionPage
}

When(~'^I add the criterion "([^"]*)" at turma "([^"]*)" and periodo "([^"]*)"$') {
    String desc, String classID, String periodo ->
        at CreateCriterionPage
        page.createCriterion(desc, classID, periodo)
}

Then(~'^I should see a message related to the criterion registration failure$') { ->
    at CreateCriterionPage
    assert page.checkForErrors()
}
