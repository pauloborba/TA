/**
 * Created by Lavinia Paganini on 03/11/2016.
 */


import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import steps.AddStudentsTestDataAndOperations
import steps.CommonTestDataAndOperations
import steps.CriterionTestDataAndOperations
import steps.EvaluationDataAndOperations
import steps.SituationStudentsTestDataAndOperation
import ta.Student
import ta.StudentController


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

Student studentToCheck

Given(~'^o aluno "([^"]*)", com login "([^"]*)", possui conceitos "([^"]*)", "([^"]*)" e "([^"]*)" em "([^"]*)"$'){
    String aluno, String login, String conceito1, String conceito2, String conceito3, String materia ->
        AddStudentsTestDataAndOperations.createStudent(aluno, login)
        studentToCheck = Student.findByLogin(login)
        assert studentToCheck.login.equals(login)
        assert studentToCheck.name.equals(aluno)
        CriterionTestDataAndOperations.createCriterion(materia)
        EvaluationDataAndOperations.createEvaluation(conceito1, materia, "Prova", "01/10/2016")
}
/*
And(~'o aluno "([^"]*)", com login "([^"]*)", possui media "([^"]*)" em "([^"]*)"'){
    String aluno, String login, String media, String conceito ->

}

When(~'eu solicito a visualização da situação do aluno "([^"]*)" com login "([^"]*)"'){
    String aluno, String login ->

}
Then(~'a média de "([^"]*)", com login "([^"]*)", em "([^"]*)" continua sendo "([^"]*)"'){
    String aluno, String login, String conceito, String media ->
}
*/