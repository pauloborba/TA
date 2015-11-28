package steps

import pages.EvaluationCriterionPages.CreateEvaluationCriterionPage
import pages.StudentPages.CreateStudentPage
import pages.StudentPages.StudentPage
import pages.AutoEvaluationPage
import ta.Student
import ta.StudentController


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def studentLogin
def concept
def studentCriterion

//Scenario: edit auto evaluation

Given (~'there is the student "([^"]*)" with login "([^"]*)"$'){ String name, login ->
    studentLogin = login
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)

}

And (~'the criterion "([^"]*)"$'){String criterion ->
    studentCriterion = criterion
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(criterion)
}

And (~'the student does not have an auto evaluation for that criterion$'){->
    assert EvaluateStudentTestDataAndOperations.getAutoEvaluationLength(studentLogin, studentCriterion)==0
}





When (~'the user inputs a new concept "([^"]*)" in that criterion$'){ String studentConcept->
    concept = studentConcept
    new StudentController().updateAutoEvaluation(studentLogin, studentCriterion, concept)
}

Then (~'the auto evaluation for that criterion on that student will be updated to "([^"]*)"$'){String studentConcept ->

    assert EvaluateStudentTestDataAndOperations.checkAutoEvaluation(studentLogin, studentCriterion, studentConcept)
}



////edit auto evaluation web
//
//Given (~'that I am on the Students page$'){ ->
//    to StudentPage
//    at StudentPage
//}
//
//And (~'there is a student named "([^"]*)" with a login "([^"]*)"$'){ String name, login ->
//    to CreateStudentPage
//    at CreateStudentPage
//
//    page.fillStudentDetails(login, name)
//    page.selectCreateStudent()
//
//    to StudentPage
//    at StudentPage
//
//    studentLogin = login
//    assert page.checkStudent(login, name)
//}
//
//And (~'one evaluation criterion named "([^"]*)"$'){ String name ->
//    to CreateEvaluationCriterionPage
//    at CreateEvaluationCriterionPage
//
//    page.fillEvaluationCriterionDetails(name)
//    page.selectCreateEvaluationCriterion()
//
//    to StudentPage
//    at StudentPage
//    criterionName = name
//
//    assert page.checkCriterion(studentLogin, name)
//}
//
//When (~'I go to the Auto Evaluation Page$'){ ->
//    to AutoEvaluationPage
//    at AutoEvaluationPage
//}
//
//And (~'I choose the student name$'){->
//    at AutoEvaluationPage
//    page.fillStudentDetails(studentLogin)
//}
//
//And (~'I choose a new concept "([^"]*)" to that student for that criterion$'){ String studentConcept ->
//    at AutoEvaluationPage
//    page.fillConceptDetails(studentLogin, criterionName, studentConcept)
//}
//
//And (~'I send the info$'){ ->
//    at AutoEvaluationPage
//    page.select(studentLogin)
//}
//
//Then (~'I go to that student page$'){->
//    to StudentPage
//    at StudentPage
//}
//
//And (~'I can see that the auto evaluation in that criterion for that student is now "([^"]*)"$'){String studentConcept ->
//    at StudentPage
//    assert true
//}