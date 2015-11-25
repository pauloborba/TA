package steps

import pages.ManualInputPage
import pages.StudentPages.StudentPage
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
def studentLogin
def criterionName


Given (~'that the student named "([^"]*)" with a login "([^"]*)" is registered in the system$') { String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}

And (~'the evaluation criterion "([^"]*)" is also registered in the system$'){ String name ->
    criterionName = name
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(name)
}

When (~'the user input manually a new concept "([^"]*)" into the student in that criterion$'){ String concept ->
    String studentCriterion = studentLogin+" / "+criterionName
    new StudentController().updateConcepts(studentCriterion, concept)
}

Then (~'the final criterion concept of that student is updated in the system$') { ->
    assert true
}

//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Student page$'){ ->
    to StudentPage
    at StudentPage
}

And (~'I can see a student named "([^"]*)" with a login "([^"]*)"$'){ String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}

And (~'a evaluation criterion named "([^"]*)"$'){ String name ->
    criterionName = name
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(name)
}

When (~'I go to the Manual Input Concept Page$'){ String cell ->
    to ManualInputPage
    at ManualInputPage
}

And (~'I choose a new concept "([^"]*)" to that student in that criterion$'){ String concept ->

}

Then (~'I go back to Student List page$'){->
    to StudentPage
    at StudentPage
}

And (~'I can see that the final concept in that criterion is updated for that student$'){->

}