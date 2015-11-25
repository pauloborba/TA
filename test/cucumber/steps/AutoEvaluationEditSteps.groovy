package steps

import pages.StudentPages.StudentPage
import ta.AutoEvaluationController
import pages.AutoEvaluationPage
import ta.Student
import ta.StudentController


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def studentLogin
def concept
def studentCriterion

//Scenario: input auto evaluation

Given (~'there is the student "([^"]*)" with login "([^"]*)"$'){ String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)

}

And (~'the criterion "([^"]*)"$'){String criterion ->
    studentCriterion = criterion
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)

}

When (~'the user inputs a new concept "([^"]*)" of the criterion "([^"]*)"$'){ String studentConcept, criterion ->
    concept = studentConcept
    new StudentController().updateAutoEvaluation(criterion, studentConcept)
}

Then (~'the new concept will be saved in the system$'){

    Student x = Student.findByLogin(studentLogin)
    assert x.autoEvaluations.get(studentCriterion).equals(concept)

}


Given (~'I am at the student page$'){
    to StudentPage
    at StudentPage
}

And  (~'I see the student "Peter Parker" with login "pp"$'){String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)

}

And (~'the criterion "([^"]*)"$'){String criterion ->
    studentCriterion = criterion
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)

}

When (~'I go to the auto evaluation page$'){
    to AutoEvaluationPage
    at AutoEvaluationPage
}

And (~'I choose a new concept "MPA" for that student in that criterion$'){

}

Then(~'I can see the concept for that criterion updated$'){

}
//Scenario: edit the auto evaluation after the time limit has ended

/*
Given (~'that the time limit for the auto evaluation of the criterion "([^"]*)" has ended$'){ String criterion ->
    autoEvaluationController = new AutoEvaluationController()
    assert autoEvaluationController.checkAvailability(criterion)
}

Then (~'The system does nothing'){

}

// Scenario web: edit the auto evaluation before the time limit has ended

Given (~'I am at the auto evaluation page$'){
    to AutoEvaluationPage
    at AutoEvaluationPage
}

When (~'I choose the criterion "([^"]*)"$'){String criterion ->
    at AutoEvaluationPage
    page.choose(criterion)
}

And (~'I put the new concept"([^"]*)"$'){String Studentconcept ->
    at AutoEvaluationPage
    page.fillConcept(concept)
}

And (~'I click the button to confirm$'){
    at AutoEvaluationPage
    page.click()
}

Then(~'the concept for that criterion is updated$'){
    at AutoEvaluationPage
    page.update()
}

// Scenario web: edit the auto evaluation after the time limit has ended

Then(~'a warning will appear'){
    at AutoEvaluationPage
    page.displayWarning()
}
*/
