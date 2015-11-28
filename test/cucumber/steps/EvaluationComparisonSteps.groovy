package steps


import pages.ShowComparisonPage
import pages.StudentPages.StudentPage
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def studentX = new StudentController()
/*
Given There is a student with the login "bw" and name "Bruce Wayne" and a criteria with name "C1" and the student appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "bw"
Then I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen
*/

Given (~'^There is a student with the login "([^"]*)" and name "([^"]*)" and a criteria with name "([^"]*)" and the student appear in the list of student that sent their auto-Evaluation$'){
    String login, name, Cname  ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        Student.findByLogin(login).autoEvaluations.put(Cname, "MA")
        Student.findByLogin(login).finalGrades.put(Cname, "MA")
        assert studentX.sentAuto(login)
}

When (~'^I choose to compare the grades of the student with the login "([^"]*)"$') {
    String login->
        to StudentPage
        at StudentPage
        page.choose(login)
}

Then (~'^I can see a detailed table with both student and the professor Evaluations being put, in each criterion, side by side in the screen$'){->
   at StudentPage
    //quando der merge com Caio ai fica o at de baixo
   // at ShowComparisonPage
}

/*
Given The student with the login "sk" and name "Selina Kyle" and a criteria with name "C1" do not appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "sk"
Then I should stay in the Student page
*/

Given (~'^The student with the login "([^"]*)" and name "([^"]*)" and a criteria with name "([^"]*)" do not appear in the list of student that sent their auto-Evaluation$'){
    String login, name, Cname ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        assert !studentX.sentAuto(login)

}


Then (~'^I should stay in the Student page$'){->
    at StudentPage
}

/*
Given The Auto-Evaluation of the student with the login "dp" and name "Diana Prince" in the criteria with name "C1" is on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "dp"
Then The system returns a detailed table with both student and the professor grades
*/

Given (~'^The Auto-Evaluation of the student with the login "([^"]*)" and name "([^"]*)" in the criteria with name "([^"]*)" is on the database$'){
    String login, name, Cname ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        Student.findByLogin(login).autoEvaluations.put(Cname, "MA")
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
Given The Auto-Evaluation of the student with the login "ac" and name "Arthur Curry" in the criteria with name "C1" is not on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "ac"
Then The system returns an error message
*/

Given (~'^The Auto-Evaluation of the student with the login "([^"]*)" and name "([^"]*)" in the criteria with name "([^"]*)" is not on the database$'){
    String login, name, Cname ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        assert !studentX.sentAuto(login)

}

Then (~'^The system returns an error message$'){->
    assert !studentX.worked
}
