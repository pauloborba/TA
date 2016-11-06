package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
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
    Given the created criterion are "Requirements definition" and "Test implementation"
    And the student "João" and the student "Pedro" are registered in the system
    When I update the grade of "João" to "MPA" in the criterion "Requirements definition"
    And I update the grade of "Pedro" to "MA" in the criterion "Requirements definition"
    Then the system notifies that is necessary send a new email with the evaluated criterion to the students
 */

Criterion crit1, crit2

//Controller Scenario
Given(~'^The criterion "([^"]*)" already exists$') {
    String c ->
        CriterionTestDataAndOperations.createCriterion(c)
        Criterion crit = CriterionTestDataAndOperations(c)
        assert crit.description.equals(c)
        crit1 = crit
}
And(~'^The criterion "([^"]*)" also exists$') {
    String c ->
        CriterionTestDataAndOperations.createCriterion(c)
        Criterion crit = CriterionTestDataAndOperations.getCriterion(c)
        assert crit.description.equals(c)
        crit2 = crit
}
And(~'^The student "([^"]*)" with login "([^"]*)" is registered in the system$') {
    String name, login ->
        AddStudentsTestDataAndOperations.createStudent(name, login)
        assert Student.findByLogin(login) != null
}
And(~'^The student "([^"]*)" with login "([^"]*)" is also registered in the system$') {
    String name, login ->
        AddStudentsTestDataAndOperations.createStudent(name, login)
        assert Student.findByLogin(login) != null
}
When(~'I update the grade of "([^"]*)" with login "([^"]*)" to "([^"]*) in the criterion "([^"]*) originated from "([^"]*)" and dated from "([^"]*)"$') {
    String name, login, grade, c, form, date ->
        EvaluationDataAndOperations.createStudent(login, name);
        EvaluationDataAndOperations.createCriterion(c);
        EvaluationDataAndOperations.createEvaluation(grade,c, form, date);
}
And(~'I update the grade of "([^"]*)" with login "([^"]*)" to "([^"]*) in the criterion "([^"]*) originated from "([^"]*)" and dated from "([^"]*)"$') {
    String name, login, grade, c, form, date ->
        EvaluationDataAndOperations.createStudent(login, name);
        EvaluationDataAndOperations.createCriterion(c);
        EvaluationDataAndOperations.createEvaluation(grade,c, form, date);
}
Then(~'The system notifies that is necessary to send a new email with the evaluated criterion to the students') {

}