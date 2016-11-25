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

Given(~'^the student "([^"]*)" login "([^"]*)" has grade "([^"]*)" in the criterion "([^"]*)" that was not sent to the students$') {
    String name, login, grade, c ->
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

Given(~'^I see the student "([^"]*)" login "([^"]*)" and the criterion "([^"]*)"$') {
    String name, login, c ->
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

}
And(~'^the system verify that there is no evaluated criterion$') {->
    to EvaluationPage
    assert Evaluation.list().size() == 0
}
When(~'^I request a sending email with the evaluated criterion$') {->
    to StudentPage
    page.sendCriterion()
}
Then(~'^the system notify that I sent a email only with the criterion that is going to be evaluated yet$') { ->
    at StudentPage
    assert page.EmailWithNoAvaliatedCriterion() != null
}

//GUI Scenario
Given(~'^I see the student "([^"]*)" with login "([^"]*)" and the criterion "([^"]*)"$') {
    String name1, login_1, c1 ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name1, login_1, login_1+"@cin.ufpe.br")
        page.selectAddStudent()

        to StudentPage

        assert page.confirmStudent(name1, login_1)

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c1)
        page.selectCreateCriterion()

        to CriterionPage
        at CriterionPage
        assert page.confirmCriterion(c1)
}
When(~'^I update the grade of all students in the criterion "([^"]*)" originated from "([^"]*)" and dated from "([^"]*)"$') {
    String c1, Origin, Date ->
        to AddEvaluationPage
        //at AddEvaluationPage
        page.chooseValue("MANA")
        page.chooseCriterion(c1)
        page.selectAddEvaluation()
}
Then(~'^the system notifies that is necessary to send a new email with the evaluated criterion to the students$') {->
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