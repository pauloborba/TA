package steps


import pages.ShowComparisonPage
import pages.StudentPages.CreateStudentPage
import pages.EvaluationCriterionPages.CreateEvaluationCriterionPage
import pages.StudentPages.StudentPage
import ta.EvaluationCriterion
import ta.Student
import ta.StudentController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def studentX = new StudentController()
/*
Scenario:  table is seen with success
*/

Given (~'^I am at the StudentPage$'){ ->
    to StudentPage
    at StudentPage
}

And (~'There is a student with the login "([^"]*)" and name "([^"]*)"$'){ String login, name ->
    to CreateStudentPage
    at CreateStudentPage

    page.fillStudentDetails(login, name)
    page.selectCreateStudent()

    to StudentPage
    at StudentPage

    studentLogin = login

    assert page.checkStudent(login, name)
}

And (~'a criterion with name "([^"]*)"$'){ String name ->
    to CreateEvaluationCriterionPage
    at CreateEvaluationCriterionPage

    page.fillEvaluationCriterionDetails(name)
    page.selectCreateEvaluationCriterion()

    to StudentPage
    at StudentPage

    assert page.checkCriterionConcept(studentLogin, name)
}

And(~'^the student with login "([^"]*)" has the grade "([^"]*)" in his evaluation in the criteria "([^"]*)"$'){
    String login, concept, Cname ->
        Student.findByLogin(login).finalGrades.put(Cname, concept)
        assert Student.findByLogin(login).finalGrades.get(Cname)==concept
}

And(~'^the student with login "([^"]*)" appear in the list of student that sent their auto-Evaluation, with "([^"]*)" in the criteria "([^"]*)"$'){
    String login, concept, Cname->
        Student.findByLogin(login).autoEvaluations.put(Cname, concept)
        Student.findByLogin(login).save(flush: true)
        assert studentX.sentAuto(login)
}

When (~'^I choose to compare the grades of the student with the login "([^"]*)"$') {
    String login->
        to StudentPage
        at StudentPage
        page.choose(login)
}
/*Then I can see a table with both student with login "bw" and the professor Evaluations being put, in each criterion, side by side in the screen.
And in the criterion "C1" the Auto Evaluation grade is "MA" and the Final grade is "MA"*/

Then (~'^I can see a table with both student with login "([^"]*)" and the professor Evaluations being put, in each criterion, side by side in the screen.$'){
    String login->
    at StudentPage
    assert page.checkStudentTable(login).contains(Student.findByLogin(login).getName())
}

And(~'^in the criterion "([^"]*)" the Auto Evaluation grade is "([^"]*)" and the Final grade is "([^"]*)"$'){
    String criteria, concept, concept2->
    at StudentPage
    String t1="";
    String t2="";
    if(concept.equals(concept2)){
        t1="Auto"
        t2="Final"
    }else{
        t1="AutoRED"
        t2="FinalRED"
    }
    assert page.checkElementTable(criteria, t1, concept) && page.checkElementTable(criteria, t2, concept2)
}

/*
Scenario:  table is not seen with success
*/

And(~'^the student with login "([^"]*)" do not appear in the list of student that sent their auto-Evaluation$'){
    String login->
        assert !studentX.sentAuto(login)
}

Then (~'^I should stay in the Student page$'){->
    at StudentPage
}

And(~'^an Error message should appear$'){->
    at StudentPage
    assert page.hasErrors()
}

/*
Scenario: The system return a table with success
*/

Given (~'^There is a student with the login "([^"]*)" and name "([^"]*)" is registered in the system$'){
    String login, name->
        EvaluateStudentTestDataAndOperations.createStudent(login, name)
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        temp=login
        assert Student.findByLogin(login)!=null
}

And (~'^a criterion with name "([^"]*)" is registered in the system$'){
    String Cname ->
        EvaluateStudentTestDataAndOperations.createEvaluationCriterion(Cname)
        assert EvaluationCriterion.findByName(Cname)!=null
}

And (~'^The Auto-Evaluation of the student with login "([^"]*)" in the criterion with name "([^"]*)" is registered in the system$'){
    String login, Cname ->
        //studentX.updateAutoEvaluation(login, Cname, "MANA")
        Student.findByLogin(login).autoEvaluations.put(Cname, "MA")
        assert studentX.sentAuto(login)
}

When (~'^There is a request of the Evaluation and Auto-evaluation comparison of student with the login "([^"]*)"$') {
    String login->
        studentX.compareGrades(login)
}

//o sistema nunca vai ser alterado já que esta operação apenas lê dados nunca insere, edita, atualiza ou remove nenhum dado
Then (~'^The system is not altered$'){->
    assert true
}

/*
Scenario: The system dont return a table with success
*/

And (~'^The Auto-Evaluation of the student with login "([^"]*)" is not registered in the system in no criterion$'){
    String login ->
        assert !studentX.sentAuto(login)
}

And (~'^The system returns an error message$'){->
    assert !studentX.worked
}


/*
*Color changed with sucess
*/

And (~'Since the grades are different in the criterion "([^"]*)" then the color of them will be both red$'){String c->
    at StudentPage
    assert page.checkColor(c)
}