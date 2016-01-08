package steps


import pages.ShowComparisonPage
import pages.StudentPages.StudentPage
import ta.EvaluationCriterion
import ta.EvaluationCriterionController
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def studentX = new StudentController()
/*
Given There is a student with the login "bw" and name "Bruce Wayne"
And a criteria with name "C1"
And the student with the login "bw" has the grade "MA" in his evaluation in the criteria "C1"
And the student appear in the list of student that sent their auto-Evaluation, with "MA" in the criteria "C1"
When I choose to compare the grades of the student with the login "bw"
Then I can see a table with both student and the professor Evaluations being put, in each criterion, side by side in the screen
*/

Given (~'^I am at the StudentPage$'){ ->
    to StudentPage
    at StudentPage
}

And (~'^There is a student with the login "([^"]*)" and name "([^"]*)"$'){
    String login, name->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        temp=login
        assert Student.findByLogin(login)!=null
}

And (~'^a criterion with name "([^"]*)"$'){
    String Cname ->
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        assert EvaluationCriterion.findByName(Cname)!=null
}

And(~'^the student with login "([^"]*)" has the grade "([^"]*)" in his evaluation in the criteria "([^"]*)"$'){
    String login, concept, Cname ->
        Student.findByLogin(login).finalGrades.put(Cname, concept)
        assert Student.findByLogin(login).finalGrades.get(Cname)==concept
}

And(~'^the student with login "([^"]*)" appear in the list of student that sent their auto-Evaluation, with "([^"]*)" in the criteria "([^"]*)"$'){
    String login, concept, Cname->
        Student.findByLogin(login).autoEvaluations.put(Cname, concept)
        assert studentX.sentAuto(login)
}

When (~'^I choose to compare the grades of the student with the login "([^"]*)"$') {
    String login->
        to StudentPage
        at StudentPage
        page.choose(login)
}

Then (~'^I can see a table with both student and the professor Evaluations being put, in each criterion, side by side in the screen$'){->
   at StudentPage
    //quando der merge com Caio ai fica o at de baixo
   // at ShowComparisonPage
}

/*
Given The student with the login "sk" and name "Selina Kyle" and a criteria with name "C1" do not appear in the list of student that sent their auto-Evaluation
When I choose to compare the grades of the student with the login "sk"
Then I should stay in the Student page
*/

And (~'^There is a student with the login "([^"]*)" and name "([^"]*)"$'){
    String login, name->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        temp=login
        assert Student.findByLogin(login)!=null
}

And (~'^a criterion with name "([^"]*)"$'){
    String Cname ->
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        assert EvaluationCriterion.findByName(Cname)!=null
}

And(~'^the student with login "([^"]*)" has the grade "([^"]*)" in his evaluation in the criteria "([^"]*)"$'){
    String login, concept, Cname ->
        Student.findByLogin(login).finalGrades.put(Cname, concept)
        assert Student.findByLogin(login).finalGrades.get(Cname)==concept
}

And(~'^the student with login "([^"]*)" do not appear in the list of student that sent their auto-Evaluation$'){
    String login->
        assert studentX.sentAuto(login)
}

Then (~'^I should stay in the Student page$'){->
    at StudentPage
}

And(~'^an Error message should appear$'){->
    at StudentPage
    assert page.hasErros()
}

/*
Given The Auto-Evaluation of the student with the login "dp" and name "Diana Prince" in the criteria with name "C1" is on the database
When The system requires the Evaluation and Auto-evaluation comparison of student with the login "dp"
Then The system returns a detailed table with both student and the professor grades
*/

And (~'^The Auto-Evaluation of the student with the login "([^"]*)" and name "([^"]*)" in the criteria with name "([^"]*)" is on the database$'){
    String login, name, Cname ->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        Student.findByLogin(login).autoEvaluations.put(Cname, "MA")
        assert studentX.sentAuto(login)

}

When (~'^There is a request of the Evaluation and Auto-evaluation comparison of student with the login "([^"]*)"$') {
    String login->
        studentX.compareGrades(login)
}

Then (~'^The system is not altered$'){->

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

Then (~'^The system is not altered$'){->

}


And (~'^The system returns an error message$'){->
    assert !studentX.worked
}
