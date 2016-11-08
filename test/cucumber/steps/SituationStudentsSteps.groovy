/**
 * Created by Lavinia Paganini on 03/11/2016.
 */


import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.AddStudentsPage
import pages.CreateCriterionPage
import steps.AddStudentsTestDataAndOperations
import steps.CommonTestDataAndOperations
import steps.CriterionTestDataAndOperations
import steps.EvaluationDataAndOperations
import steps.SituationStudentsTestDataAndOperation
import ta.Evaluation
import ta.EvaluationsByCriterion
import ta.SituationStudentsController
import ta.Student
import ta.StudentController

import static pages.AddStudentsPage.*


this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

/*
    #Controle
    Scenario: Visualizar a nota do aluno
      Given o aluno “João Vasconcelos”, com login "jvsn", possui conceitos “MA”, “MPA” e “MA” em “Requisitos de Sistemas”
      And o aluno "João Vasconcelos", com login "jvsn", possui media “MA” em “Requisitos de Sistemas”
      When eu solicito a visualização da situação do aluno "João Vasconcelos" com login "jvsn"
      Then a média de “João Vasconcelos”, com login "jvsn", em “Requisitos de Sistemas” continua sendo “MA”
 */

List<EvaluationsByCriterion> criteriosLista


Given(~'^o aluno "([^"]*)", com login "([^"]*)", possui conceitos "([^"]*)", "([^"]*)" e "([^"]*)" em "([^"]*)"$') {
    String aluno, login, conceito1, conceito2, conceito3, materia ->
        AddStudentsTestDataAndOperations.createStudent(aluno, login)
        studentToCheck = Student.findByLogin(login)
        assert studentToCheck.login.equals(login)
        assert studentToCheck.name.equals(aluno)
        CriterionTestDataAndOperations.createCriterion(materia)
        assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito1, materia, "Form", "10/10/2016", login)
        assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito2, materia, "Mini-Test", "09/10/2016", login)
        assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito3, materia, "Test", "11/10/2016", login)

}

And(~'o aluno "([^"]*)", com login "([^"]*)", possui media "([^"]*)" em "([^"]*)"'){
    String aluno, String login, Double media, String conceito ->
        Student estudante = Student.findByName(aluno)
        estudante.calcMedia()
        assert(estudante.findEvaluationByCriterion(conceito).criterionAverage.equals(media))
}

When(~'eu solicito a situação do aluno "([^"]*)" com login "([^"]*)"'){
    String aluno, String login ->
    Student estudante = Student.findByName(aluno)
        criteriosLista = estudante.getCriteriaAndEvaluations()
}
Then(~'a média de "([^"]*)", com login "([^"]*)", em "([^"]*)" continua sendo "([^"]*)"'){
    String aluno, String login, String conceito, Double media ->
        assert(Student.findByName(aluno).getCriteriaAndEvaluations().equals(criteriosLista))
        assert(Student.findByName(aluno).findEvaluationByCriterion(conceito).criterionAverage.equals(media))
}

/*
#GUI
    Scenario: Visualizar media positiva dos alunos
      Given o aluno "João Vasconcelos", com login "jvsn", possui média "8" em "Requisitos de Sistemas"
      When eu solicito a página "Visualização"
      Then a média do aluno "João Vasconcelos", com login "jvsn", em "Requisitos de Sistemas" aparece verde e com uma seta para cima
 */
/*
Given(~'^o aluno "([^"]*)", com login "([^"]*)", possui média "([^"]*)" em "([^"]*)"$'){
    String aluno, String login, double media, String conceito ->
        to AddStudentsPage
        at AddStudentsPage
        AddStudentsPage.fillStudentDetails(aluno,login)
        page.selectAddStudent()
        to CreateCriterionPage
        at CreateCriterionPage
}
*/