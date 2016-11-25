package steps

import cucumber.api.PendingException
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.EvaluationPages.EvaluationPage
import pages.StudentPages.ResendPage
import pages.StudentPages.ShowStudentPage
import pages.StudentPages.StudentPage
import ta.Student

//Email New Grades Feature, Created By ArthurCosta


this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~/^There are grades from student “([^"]*)” with email “([^"]*)” evaluated as “([^"]*)” in the “([^"]*)” criteria on the system that were not yet sent$/) {
        String name, String email,String grade,String criteria->
            to AddStudentsPage
            page.fillStudentDetails(name, email, email)
            page.selectAddStudent()
            to CreateCriterionPage
            page.createCriterion(criteria)
            to AddEvaluationPage
            page.chooseCriterion(criteria)
            page.chooseValue(grade)
            page.selectAddEvaluation()
}
Then(~/^An email is sent to “([^"]*)” Telling he received an “([^"]*)” on “([^"]*)”$/) {
    String email,String grade,String criteria->
        to StudentPage
        page.selectStudentByEmail(email)
        at ShowStudentPage
        assert page.isAllSent()
}
When(~/^I request to send new grades$/) { ->
    to StudentPage
    page.sendNewEvaluations()
}
Given(~/^All grades on the system have been already sent$/) { ->
    to AddStudentsPage
    page.fillStudentDetails("Tester", "test", "test@test.te")
    page.selectAddStudent()
    to CreateCriterionPage
    page.createCriterion("C1")
    to AddEvaluationPage
    page.chooseCriterion("C1")
    page.chooseValue("MPA")
    page.selectAddEvaluation()
    to StudentPage
    page.sendNewEvaluations()
}
And(~/^I am on the students index page$/) { ->
    to StudentPage
}
Then(~/^the system asks if I want to resend$/) { ->
    at ResendPage
}