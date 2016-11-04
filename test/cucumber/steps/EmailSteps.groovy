package steps

import cucumber.api.PendingException
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.EvaluationPages.EvaluationPage

//Email New Grades Feature, Created By ArthurCosta


this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~/^There are grades from student “([^"]*)” with email “([^"]*)” evaluated as “([^"]*)” in the “([^"]*)” criteria on the system that were not yet sent$/) {
    String name, String email,String grade,String criteria->

}
Then(~/^An email is sent to “([^"]*)” Telling he received an “([^"]*)” on “([^"]*)” and that his “([^"]*)” criteria was not evaluated yet\.$/) {
    String email,String grade,String criteria1,String criteria2->
}
When(~/^I request to send new grades$/) { ->
}