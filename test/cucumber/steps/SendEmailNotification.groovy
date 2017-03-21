package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.CriterionPages.CriterionPage
import pages.EvaluationPages.EvaluationPage
import pages.StudentPages.StudentPage
import ta.Criterion
import ta.Evaluation
import ta.EvaluationsByCriterion
import ta.Student
import ta.StudentController

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
/**
 * Created by Rodrigo on 05/11/2016.
 */

Given(~'^The only not yet sent grade is "([^"]*)" in the criterion "([^"]*)" from the student "([^"]*)" with login "([^"]*)"$') {
    String grade, c, name, login ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name, login, login+"@cin.ufpe.br")
        page.selectAddStudent()

        to StudentPage

        assert page.confirmStudent(name, login)

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c)

        to AddEvaluationPage
        page.chooseCriterion(c)
        page.chooseValue(grade)
        page.selectAddEvaluation()
}
When(~'^I request to send email with evaluated criterion$') { ->
    to StudentPage
    page.sendCriterion()
}
Then(~'^I should see a message notifying that the email have been successfully sent$') { ->
    at StudentPage
    assert page.emailSend() != null
}

Given(~'^the student "([^"]*)" that has login "([^"]*)" is in the system$') {
    String name, login ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name, login, login+"@cin.ufpe.br")
        page.selectAddStudent()

        to StudentPage

        assert page.confirmStudent(name, login)

}
And(~'the criterion "([^"]*)" is registered in the system$') {
    String c ->
        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c)
}
And(~'^the system verifies that there is no evaluated criterion$') {->
    to EvaluationPage
    assert page.NoExistEvaluation() == 0
}
When(~'^I request a sending email with the evaluated criterion$') {->
    to StudentPage
    page.sendCriterion()
}
Then(~'^I should see a message that I sent a email only with the criterion that is going to be evaluated yet$') { ->
    at StudentPage
    assert page.EmailWithNoAvaliatedCriterion() != null
}

//GUI Scenario
Given(~'^the student with name "([^"]*)" and login "([^"]*)" is in the system$') {
    String name1, login_1 ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name1, login_1, login_1+"@cin.ufpe.br")
        page.selectAddStudent()

        to StudentPage

        assert page.confirmStudent(name1, login_1)
}
And(~'the criterion with name "([^"]*)" is in the system$') {
    String c1 ->
        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c1)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c1)
}
When(~'^the criterion "([^"]*)" originated from "([^"]*)" and dated from "([^"]*)" has the grade updated$') {
    String c1, Origin, Date ->
        to AddEvaluationPage
        //at AddEvaluationPage
        page.chooseValue("MANA")
        page.chooseCriterion(c1)
        page.selectAddEvaluation()
}
Then(~'^I should see a message that is necessary to send a new email with the evaluated criterion to the students$') {->
        //to EvaluationPage
        at EvaluationPage
        assert page.needEmail() != null
}

Given(~'^the student "([^"]*)" login "([^"]*)" is in the system$') {
    String name, login ->
        AddStudentsTestDataAndOperations.createStudent(name, login, login + "@cin.ufpe.br")
}
When(~'^I request to send an email with evaluated criterion$') { ->
    AddStudentsTestDataAndOperations.sendStudentEmail()
}
Then(~'^the student "([^"]*)" with login "([^"]*)" is still in the system$') {
    String name, login ->
        assert Student.findByLogin(login) != null
}

Given(~'^the student "([^"]*)" that has login "([^"]*)" is registered in the system$') {
    String name, login ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name, login, login+"@cin.ufpe.br")
        page.selectAddStudent()

        to StudentPage

        assert page.confirmStudent(name, login)
}
And(~'^The only not yet sent grades are "([^"]*)" in the criterion "([^"]*)" and "([^"]*)" in the criterion "([^"]*)"$') {
    String grade1, c1, grade2, c2 ->

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c1)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c1)

        to AddEvaluationPage
        page.chooseCriterion(c1)
        page.chooseValue(grade1)
        page.selectAddEvaluation()

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c2)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c2)

        to AddEvaluationPage
        page.chooseCriterion(c2)
        page.chooseValue(grade2)
        page.selectAddEvaluation()
}
When(~'^I request a sending email with evaluated criterion$') { ->
    to StudentPage
    page.sendCriterion()
}
Then(~'^I should see a message that notifies that the email have been successfully sent$') { ->
    at StudentPage
    assert page.emailSend() != null
}