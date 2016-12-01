package steps

import pages.StudentPages.StudentPage
import ta.Criterion
import ta.Evaluation
import ta.Student
import ta.Turma
import steps.EvaluationDataAndOperations
import pages.*
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


String criterionNameGlobal, originGlobal;
String dateGlobal;

def numberOfEvaluationsBeforeStep = []
Boolean stored = false;



Given(~/^there are no evaluations to all students to the "([^"]*)" criterion at turma "([^"]*)" and periodo "([^"]*)", originated from a "([^"]*)" and dated from "([^"]*)"$/) {
    String criterionName, String classID, String periodo, String origin, String dateInString  ->
        EvaluationDataAndOperations.createStudents(1);
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        student = EvaluationDataAndOperations.getStudent("eebls")
        ClassTestDataAndOperations.addStudent(student.id, t.id)
        EvaluationDataAndOperations.createCriterion(criterionName, t.id.toString());
        numberOfEvaluationsBeforeStep = EvaluationDataAndOperations.numberOfEvaluationsBeforeTest();
        assert EvaluationDataAndOperations.checkEvaluationAllStudents(numberOfEvaluationsBeforeStep,"same");
}

When(~/^I want to evaluate all students to the "([^"]*)" criterion at turma "([^"]*)" and periodo "([^"]*)", originated from a "([^"]*)" and dated from "([^"]*)"\.$/) {
    String criterionName, String classID, String periodo, String origin, String dateInString ->
        dateGlobal = dateInString
        criterionNameGlobal = criterionName
        originGlobal = origin
        String value = "MA";
        EvaluationDataAndOperations.createEvaluation(value, criterionName, origin, dateInString)
}

Then(~/^all the evaluations will be stored in on the "([^"]*)" criterion at turma "([^"]*)" and periodo "([^"]*)" history of each student$/) {
    String criterionName, String classID, String periodo -> assert EvaluationDataAndOperations.checkEvaluationAllStudents(numberOfEvaluationsBeforeStep,"more")
}


///
Given(~/^there are no evaluations to all students to the "([^"]*)" criterion at turma "([^"]*)" and periodo "([^"]*)", without a specific origin and dated from "([^"]*)"$/) {
    String criterionName, String classID, String periodo, String dateInString ->
        assert EvaluationDataAndOperations.createStudents(2);
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        assert EvaluationDataAndOperations.createCriterion(criterionName, t.id.toString());
        numberOfEvaluationsBeforeStep = EvaluationDataAndOperations.numberOfEvaluationsBeforeTest()
        assert EvaluationDataAndOperations.checkEvaluationAllStudents(numberOfEvaluationsBeforeStep, "same")
}

When(~/^I want to evaluate all students to a the "([^"]*)" criteria at turma "([^"]*)" and periodo "([^"]*)", without a specific origin and dated from "([^"]*)"\.$/) {
    String criterionName, String classID, String periodo, String dateInString ->
        criterionNameGlobal = criterionName
        dateGlobal = dateInString;
        assert EvaluationDataAndOperations.createEvaluation(null, criterionName, "", dateInString) == false
}

Then(~/^all evaluations will not be stored in on the "([^"]*)" criterion at turma "([^"]*)" and periodo "([^"]*)" history of each student$/) {
    String criterionName, String classID, String periodo ->
    assert EvaluationDataAndOperations.checkEvaluationAllStudents(numberOfEvaluationsBeforeStep, "same")
}



///Este teste não faz mais sentido. Agora não fazemos mais arrays de alunos, e o valor é adicionado diretamente à turma
/*
Given(~'^evaluations for every student on the "([^"]*)" criteria at turma "([^"]*)" and periodo "([^"]*)", originated from "([^"]*)" and dated from "([^"]*)" are already in the system$') {
    String criterionName, String classID, String periodo, String origin, String dateInString ->
        EvaluationDataAndOperations.createStudents(5);
        ClassTestDataAndOperations.createClass(classID, periodo)
        t = ClassTestDataAndOperations.getTurma(classID, periodo)
        student = EvaluationDataAndOperations.getStudent("eebls")
        ClassTestDataAndOperations.addStudent(student.id, t.id)
        EvaluationDataAndOperations.createCriterion(criterionName, t.id.toString());
        EvaluationDataAndOperations.createEvaluation("MANA", criterionName, origin, dateInString);
}

When(~/^I want to add a mark to all students to a the "([^"]*)" criteria at turma "([^"]*)" and periodo "([^"]*)", originated from "([^"]*)" and dated from "([^"]*)"$/) {
    String criterionName, String classID, String periodo, String origin, String dateInString ->
        dateGlobal = dateInString;
        originGlobal = origin;
        assert EvaluationDataAndOperations.createEvaluation("MANA", criterionName, origin, dateInString) == false
}

Then(~/^all the marks will not be stored in on the "([^"]*)" criteria's at turma "([^"]*)" and periodo "([^"]*)" history of each student$/) {
    String criterionName, String classID, String periodo ->
        assert EvaluationDataAndOperations.checkEvaluationAllStudents(numberOfEvaluationsBeforeStep, "same")
}



/*
String studentNameGlobal, studentLoginGlobal;
Given(~/^I see the student "([^"]*)", login "([^"]*)" and the criterion "([^"]*)"$/) {
    String studentName, studentLogin, criterionName ->
        to AddStudentsPage
//        at AddStudentsPage
        studentLoginGlobal = studentLogin;
        studentNameGlobal = studentName;
        page.fillStudentDetails(studentName, studentLogin)
        page.selectCreateStudent()

        to StudentPage

        assert page.confirmStudent(studentName, studentLogin)

        to CreateCriterionPage
//        at CreateCriterionPage

        page.fillCriterionDetails(criterionName)
        page.selectCreateCriterion()

        to CriterionPage

        assert page.confirmCriterion(criterionName)

}

When(~/^I request the system to add the evaluation valued "([^"]*)" in the criterion "([^"]*)", from "([^"]*)", date "([^"]*)"$/) {
    String value, criterionName, evaluationOrigin, evaluationDate, studentName, studentLogin ->
        to AddEvaluationPage
        at AddEvaluationPage
        page.chooseCriterion(criterionName)
        page.chooseValue(value)
        page.chooseOrigin(evaluationOrigin)
        page.chooseEvaluationDate(evaluationDate)
        assert page.selectCreateStudent()
}

Then(~/^I can see the evaluation valued "([^"]*)" in the criterion "([^"]*)", from "([^"]*)", date "([^"]*)" in the evaluation screen$/) {
    String value, criterionName, evaluationOrigin, evaluationDate ->
        to StudentPage
        at StudentPage

        page.selectStudent(studentNameGlobal, studentLoginGlobal)

        to ShowStudentPage

        assert page.confirmStudent(studentName, studentLogin)
        page.selectCriterion(criterionName)

        to ShowEvaluationByCriterionPage

        assert page.checkForEvaluation(value)
}






/*Scenario: Add evaluations using incomplete data
Given there are no evaluations to all students to the "X" criterion, dated from "28/03/2016", with any origin
        When I want to evaluate all students to a the "X" criteria, without a specific origin and dated from "28/03/2016".
        Then all evaluations will not be stored in on the "X" criterion history of each student*/
//////////////////////////////////

//////////////////////////////////

/*Scenario: Add evaluation more than once with same origin
Given evaluations for every student on the "X" criteria, originated form "Test" and dated from "28/03/2016" are already in the system
   When I want to evaluate all students on the "X" criteria, originated from "Test" and dated from "28/03/2016"
   Then all the marks will not be stored in on the "X" criteria's history of each student*/



/*Scenario: Error related to add a  evaluation
Given I am at the "Add concept" screen
When I want to evaluate all students to a the "X" criteria, without a specific origin and dated from "28/03/2016".
Then an error message related to trying to add a evaluation with missing values will be displayed*/
////////////////////////////////