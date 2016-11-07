package steps

import cucumber.api.PendingException
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.EvaluationPages.EvaluationPage
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
            //to EvaluationPage

}
Then(~/^An email is sent to “([^"]*)” Telling he received an “([^"]*)” on “([^"]*)” and that his “([^"]*)” criteria was not evaluated yet\.$/) {
    String email,String grade,String criteria1,String criteria2->
}
When(~/^I request to send new grades$/) { ->
    to StudentPage
    page.sendNewEvaluations()
}