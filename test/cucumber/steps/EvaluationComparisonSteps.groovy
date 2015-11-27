package steps

import pages.EvaluationComparisonPage
import pages.ShowComparisonPage
import pages.StudentPages.StudentPage
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def studentX = new StudentController()

/*
Given the student "X" appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen.
*/

Given (~'^There is a student with the login "([^"]*)" and name "([^"]*)" and a criteria with name "([^"]*)" and the student appear in the list of student that sent their auto-Evaluation$'){
    String name, login, Cname  ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        Student.findByLogin(login).autoEvaluations.put(Cname, "MA")
        assert studentX.sentAuto(login)
}

When (~'^I choose to compare the grades of the student with the login "([^"]*)"$') {
    String login->
        to StudentPage
        at StudentPage
        page.choose(login)
}

Then (~'^I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen$'){->
   at ShowComparisonPage
}

/*
Given the student "X" don't appear in the list of student that sent their auto-Evaluation
When I select the compare grades option
And choose to compare student "X" grades
Then I can see a error message with a go-back button to go to the main page.
*/

Given (~'^The student with the login "([^"]*)" and name "([^"]*)" do not appear in the list of student that sent their auto-Evaluation$'){
    String login, name ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        assert !studentX.sentAuto(login)

}


Then (~'^I should stay in the Student page$'){->
    at StudentPage
}

/*
Given Student "X"�s Auto-Evaluation is on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns a detailed table with both student and the professor grades.
*/

Given (~'^The Auto-Evaluation of the student with the login "([^"]*)" is on the database$'){
    String login ->
       assert studentX.sentAuto(login)

}

When (~'^The system requires the Evaluation and Auto-evaluation comparison of student with the login "([^"]*)"$') {
    String login->
        studentX.compareGrades(login)
}

Then (~'^The system returns a detailed table with both student and the professor grades$'){->
    assert studentX.worked

}


/*
Given Student "X"�s Auto-Evaluation isn�t on the database
When the system requires the  Evaluation -> Auto-evaluation comparison
Then the system returns an exception.
*/

Given (~'^The Auto-Evaluation of the student with the login "([^"]*)" is not on the database$'){
    String login ->
        assert !studentX.sentAuto(login)

}

Then (~'^The system returns an error message$'){->
    assert !studentX.worked
}
