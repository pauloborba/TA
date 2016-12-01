/**
 * Created by TMB on 23/06/2016.
 */


import pages.AddGroupCriteriaPage
import pages.CriterionPages.CriterionPage
import pages.CreateCriterionPage
import pages.TurmaPages.CopyTurmaPage
import pages.TurmaPages.TurmasPage
import steps.ClassTestDataAndOperations
import steps.CriterionTestDataAndOperations
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import ta.Criterion
import ta.Turma
import ta.EvaluationsByCriterion
import pages.TurmaPages.CreateTurmaPage
import pages.TurmaPages.TurmasPage
import steps.ClassTestDataAndOperations

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Turma t

/*
Feature: Add Criterion
  As the teacher
  I want to be able to register new criteria
  So I can evaluate the students with these criteria
*/

Criterion crit1, crit2
String tempDesc, descriptionCrit1, descriptionCrit2
int qtCriteria = 0

/*
Feature: Copy Criterion from existing Class to new Class
  As a teacher
  I want to add a new class and copy criteria between classes
  So that I can better manage my different classes

#Controller scenario
  Scenario: copy class and reuse criterion
    Given
    And the system has no class named "ESS" with periodo "2017.1"
    When I copy the class named "ESS" setting periodo to "2017.1"
    Then the class "ESS" with periodo "2017.1" has previous criterion
    And is properly stored in the system

*/

/*
Given(~'^the system has a class named "([^"]*)" and periodo "([^"]*)"$') {
    String classID, String periodo ->
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        assert t != null
}

And(~'^the system has no class named "([^"]*)" with periodo "([^"]*)"$') {
    String classID, String periodo ->
        assert ClassTestDataAndOperations.getTurma(classID, periodo) == null
}

When(~'^I copy the class named "([^"]*)" setting periodo to "([^"]*)"$') {
    String classID, String periodo ->
        saveCopy()
}

Then(~'^the class "([^"]*)" with periodo "([^"]*)" is properly stored in the system containing previous criterion$') {
    String classID, String periodo ->
        assert ClassTestDataAndOperations.getTurma(classID, periodo) != null
}

*/

/*
#GUI scenario
  Scenario: copy class and reuse criterion gui
    Given I am at the Turma List page
    When I choose to copy a class with ID "ESS" and periodo "2016.2"
    And I fill periodo with "2017.1"
    Then I can see a confirmation message
    And I can see a new class named "ESS" with periodo "2017.1" at the Turma List page
*/
Given(~'^I am at the Turma List page$') { ->
    to TurmasPage
    at TurmasPage
}

When(~'^I choose to copy a class with ID "([^"]*)" and periodo "([^"]*)"$') {
    String classID, String periodo ->
        to CopyTurmaPage
}

And(~'^I fill periodo with "([^"]*)"$') {
    String periodo ->
        at CopyTurmaPage
        page.copyTurma()
}

Then(~'^I can see a new class named "([^"]*)" with periodo "([^"]*)" at the Turma List page$') {
    String classID, String periodo ->
        to TurmasPage
        at TurmasPage
        assert page.confirmTurma(classID, periodo)
}
