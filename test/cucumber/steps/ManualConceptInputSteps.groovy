package steps

import pages.ManualInputPage
import pages.StudentPages.StudentPage
import ta.StudentController
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
def studentLogin
def criterionName
def conceptsLenght
def inputConcept

Given (~'that the student named "([^"]*)" with a login "([^"]*)" is registered in the system$') { String name, login ->
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}

And (~'the evaluation criterion "([^"]*)" is also registered in the system$'){ String name ->
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(name)
}

And (~'the student "([^"]*)" doesn\'t have a concept in the criterion "([^"]*)"$'){ String login, criterion->
    assert EvaluateStudentTestDataAndOperations.getConceptsLength(login, criterion) == 0
}

When (~'the user input manually a new concept "([^"]*)" into the student "([^"]*)" in the criterion "([^"]*)"$') { String concept, login, criterion ->
    EvaluateStudentTestDataAndOperations.updateConcept(login, criterion, concept)
}

Then (~'the new concept "([^"]*)" of the criterion "([^"]*)" is stored in the student "([^"]*)"$') { String concept, criterion, login ->
    assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(login, criterion, concept)
}

And (~'the final concept of the criterion "([^"]*)" of the student "([^"]*)" is updated to "([^"]*)" in the system$') { String criterion, login, concept ->
    assert EvaluateStudentTestDataAndOperations.getFinalGrade(login, criterion).equals(concept)
}

And (~'the student "([^"]*)" already have the concepts "([^"]*)" in the criterion "([^"]*)"$') {  String login, criteria, criterion ->
    String[] crit = criteria.split(", ")

    for( String i : crit ){
        EvaluateStudentTestDataAndOperations.updateConcept(login, criterion, i)
    }

    assert EvaluateStudentTestDataAndOperations.checkConcepts(login, criterion, crit);
}

//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Student page$'){ ->
    to StudentPage
    at StudentPage
}

And (~'I can see a student named "([^"]*)" with a login "([^"]*)"$'){ String name, login ->
    studentLogin = login
    assert page.checkStudent(login, name)
}

And (~'I can see a evaluation criterion named "([^"]*)"$'){ String name ->
    to CreateEvaluationCriterionPage
    at CreateEvaluationCriterionPage

    page.fillEvaluationCriterionDetails(name)
    page.selectCreateEvaluationCriterion()

    to StudentPage
    at StudentPage

    assert page.checkCriterionConcept(studentLogin, name)
}

And (~'I can\'t see a concept for the student "([^"]*)" in the criterion "([^"]*)"$'){ String login, criterion->
    at StudentPage
    assert page.checkCriterionConcept(login, criterion)
}

When (~'I go to the Manual Input Concept Page$'){ ->
    to ManualInputPage
    at ManualInputPage
}

And (~'I choose a new concept "([^"]*)" for the student "([^"]*)" in the criterion "([^"]*)"$'){ String concept, login, criterion ->
    at ManualInputPage
    page.fillConceptDetails(login, criterion, concept)
}

And (~'I submit the info$'){ ->
    at ManualInputPage
    page.click(studentLogin)
}

Then (~'I can see that the final concept of the criterion "([^"]*)" for the student "([^"]*)" is "([^"]*)"$'){String criterion, login, concept ->
    at StudentPage
    assert page.checkCriterionConcept(login, criterion, concept)
}

And (~'I already put the concepts "([^"]*)" for the student "([^"]*)" in the criterion "([^"]*)"$'){String criteria, login, criterion ->

    String[] crit = criteria.split(", ")

    for( String i : crit ){
        to ManualInputPage
        at ManualInputPage
        page.fillConceptDetails(login, criterion, i)
        page.click(login)
    }

}

And (~'I can see that the concept for the student "([^"]*)" in the criterion "([^"]*)" is "([^"]*)"$') { String login, criterion, concept ->
    at StudentPage
    assert page.checkCriterionConcept(login, criterion, concept)
}

And (~'I can\'t see any evaluation criterion$'){ ->
    at StudentPage

    assert page.checkCriteria(studentLogin)
}

Then (~'I can see an error message$'){->
    at ManualInputPage
    assert page.checkError()
}