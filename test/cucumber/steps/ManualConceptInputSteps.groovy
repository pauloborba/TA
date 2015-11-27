package steps

import pages.EvaluationCriterionPages.CreateEvaluationCriterionPage
import pages.ManualInputPage
import pages.StudentPages.CreateStudentPage
import pages.StudentPages.StudentPage
import ta.StudentController
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
def studentLogin
def criterionName
def inputConcept

Given (~'that the student named "([^"]*)" with a login "([^"]*)" is registered in the system$') { String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}

And (~'the evaluation criterion "([^"]*)" is also registered in the system$'){ String name ->
    criterionName = name
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(name)
}

And (~'the student doesn\'t have a concept in that criterion$'){ ->
    assert EvaluateStudentTestDataAndOperations.getConceptsLength(studentLogin, criterionName) == 0
}

When (~'the user input manually a new concept "([^"]*)" into the student in that criterion$'){ String concept ->
    inputConcept = concept
    EvaluateStudentTestDataAndOperations.updateConcept(studentLogin, criterionName, concept)
}

Then (~'the new concept of that criterion is stored in the student$') { ->
    assert EvaluateStudentTestDataAndOperations.checkConceptUpdate(studentLogin, criterionName, inputConcept)
}

And (~'the final criterion concept of that student is updated to "([^"]*)" in the system$'){ String concept ->
    assert EvaluateStudentTestDataAndOperations.getFinalGrade(studentLogin, criterionName).equals(concept)
}

And (~'the student already have the concepts "([^"]*)" and "([^"]*)" in that criterion$'){ String concept1, concept2 ->
    EvaluateStudentTestDataAndOperations.updateConcept(studentLogin, criterionName, concept1)
    EvaluateStudentTestDataAndOperations.updateConcept(studentLogin, criterionName, concept2)

    String[] concepts = new String[2]
    concepts[0] = concept1
    concepts[1] = concept2

    assert EvaluateStudentTestDataAndOperations.checkConcepts(studentLogin, criterionName, concepts )
}


//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Student page$'){ ->
    to StudentPage
    at StudentPage
}

And (~'I can see a student named "([^"]*)" with a login "([^"]*)"$'){ String name, login ->
    to CreateStudentPage
    at CreateStudentPage

    page.fillStudentDetails(login, name)
    page.selectCreateStudent()

    to StudentPage
    at StudentPage

    studentLogin = login
    assert page.checkStudent(login, name)
}

And (~'a evaluation criterion named "([^"]*)"$'){ String name ->
    to CreateEvaluationCriterionPage
    at CreateEvaluationCriterionPage

    page.fillEvaluationCriterionDetails(name)
    page.selectCreateEvaluationCriterion()

    to StudentPage
    at StudentPage
    criterionName = name

    assert page.checkCriterion(studentLogin, name)
}

And (~'I can\'t see a concept in that criterion$'){ ->
    at StudentPage
    assert page.checkConcept(studentLogin, criterionName)
}

When (~'I go to the Manual Input Concept Page$'){ ->
    to ManualInputPage
    at ManualInputPage
}

And (~'I choose a new concept "([^"]*)" to that student in that criterion$'){ String concept ->
    at ManualInputPage
    page.fillConceptDetails(studentLogin, criterionName, concept)
}

And (~'I submit the info$'){ ->
    at ManualInputPage
    page.click(studentLogin)
}

Then (~'I go back to Student page$'){->
    to StudentPage
    at StudentPage
}

And (~'I can see that the final concept in that criterion for that student is now "([^"]*)"$'){String concept ->
    at StudentPage
    assert page.checkConcept(studentLogin, criterionName, concept)
}

And (~'I can\'t see any evaluation criterion$'){ ->
    at StudentPage
    assert page.checkCriteria(studentLogin)
}

Then (~'I can see an error message$'){->
    at ManualInputPage
    assert page.checkError()
}
