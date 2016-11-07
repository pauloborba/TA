package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.EvaluationPages.EvaluationPage
import pages.StudentPages.StudentPage
import ta.Criterion
import ta.Student

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
/**
 * Created by Rodrigo on 05/11/2016.
 */

/*
    #Controller Scenario
  Scenario: notify that a email has to be send
    Given the criterion "Requirements definition" already exists
    And the criterion "Test implementation" also exists
    And the student "João" with login "J" is registered in the system
    And the student "Pedro" with login "P" is also registered in the system
    When I update the grade of all students in the criterion "Requirements definition" originated from "Test" and dated from "02/02/2016"
    Then the system notifies that is necessary to send a new email with the evaluated criterion to the students
 */
String login1, login2
Criterion crit1

//GUI Scenario
Given(~'^I see the students "([^"]*)" with login "([^"]*)" and "([^"]*)" with login "([^"]*)" and the criterion "([^"]*)"$') {
    String name1, login_1, name2, login_2, c1 ->
        to AddStudentsPage
//        at AddStudentsPage

        page.fillStudentDetails(name1, login_1)
        page.selectCreateStudent()

        to StudentPage

        assert page.confirmStudent(name1, login_1)

        to AddStudentsPage
        //at AddStudentsPage

        page.fillStudentDetails(name2, login_2)
        page.selectCreateStudent()

        to StudentPage

        assert page.confirmStudent(name2, login_2)

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(c1)
        page.selectCreateCriterion()

        to CriterionPage

        assert page.confirmCriterion(c1)
}
When(~'^I update the grade of all students in the criterion "([^"]*)" originated from "([^"]*)" and dated from "([^"]*)"$') {
    String grade, c1, Origin, Date ->
        to AddEvaluationPage
        at AddEvaluationPage
        page.chooseValue(grade)
        page.chooseCriterion(c1)
        page.chooseOrigin(Origin)
        page.chooseEvaluationDate(Date)
        assert page.selectCreateStudent()
}
Then(~'^the system notifies that is necessary to send a new email with the evaluated criterion to the students$') {
        to EvaluationPage
        at EvaluationPage
        assert page.needEmail()
}