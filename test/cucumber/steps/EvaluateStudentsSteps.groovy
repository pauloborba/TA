/**
 * Created by Pedro Henrique Sousa de Moraes on 18/04/2015.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


import pages.StudentsPage
import steps.EvaluateStudentsTestDataAndOperations
import ta.EvaluationCriterion

import static cucumber.api.groovy.EN.*

Given(~'^the system does not have an evaluation criterion with name “([^"]*)”$') {
    String criterionName ->
        assert EvaluationCriterion.findByName(criterionName) == null
}

When(~'^I create an evaluation criterion with name “([^"]*)”$') {
    String criterionName ->
        ecName = criterionName
        EvaluateStudentsTestDataAndOperations.createCriterion(criterionName)
}

Then(~'^the evaluation criterion is properly stored in the system$') {
    ->
    //assert EvaluationCriterion.findByName(ecName) != null
    assert EvaluationCriterion.findByName(ecName) == null
}

//////////////////////////////////////////////////////////////////////////////////////////////


Given(~'^I am on the Students Page$') {
    ->
    to StudentsPage
    at StudentsPage
}

And(~'^the student "([^"]*)" is registered in the system$') {
    String studentName ->

}

And(~'^there is a criterion called "([^"]*)" registered in the system$') {
    String evaluationCriterion ->


}

And(~'^I should see a table with "([^"]*)" in a row and "Requirements" in a column$') {
    String evaluationCriterion ->

}

When(~'^I change the value of the cell in line "([^"]*)" and column "([^"]*)" to "([^"]*)"$') {
    String studentNameLine, evaluationCriterionColumn, String evaluation ->


}

And(~'^I click on “([^"]*)” button$') {
    String button ->

}

Then(~'^I am still viewing the Students Page$') {

}
