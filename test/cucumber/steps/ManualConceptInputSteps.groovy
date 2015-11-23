package steps

import pages.ManualConceptInputPage
import ta.EvaluationCriterion
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Spreadsheet with at least one student and one criterion
def studentName
def criterionName


Given (~'that the student named "([^"]*)" with a login "([^"]*)" is registered in the system$') { String name, login ->
    studentName = name
    assert EvaluateStudentTestDataAndOperations.createStudent(login, name)
}

And (~'the evaluation criterion "([^"]*)" is also registered in the system$'){ String name ->
    criterionName = name
    assert EvaluateStudentTestDataAndOperations.createEvaluationCriterion(name)
}

When (~'the user input manually a new concept "([^"]*)" into the student in that criterion$'){ String concept ->
    String studentCriterion = studentName+"/"+criterionName
    new StudentController().updateConcepts(studentCriterion, concept)
}

Then (~'the final criterion concept of that student is updated in the system$') { ->

}

//Scenario: Spreadsheet with at least one student and one criterion
Given(~'that I am on the Manual Concept Input Page$'){ ->
    to ManualConceptInputPage
    at ManualConceptInputPage
}

And (~'I can see a student with login "([^"]*)"$'){->

}

And (~'a evaluation criterion named "([^"]*)"$'){->

}

When (~'I choose a new concept "([^"]*)" to that student in that criterion$'){ String cell ->

}

Then (~'I go back to Student List page$'){->

}

And (~'I can see that the final concept in that criterion is updated for that student$'){->

}