package steps

import cucumber.api.PendingException
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.SituationStudentPage
import ta.EvaluationsByCriterion
import ta.Student


/**
 * Created by lavin on 29/11/2016.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

List<EvaluationsByCriterion> criteriosLista

Given(~/^o aluno "([^"]*)", com login "([^"]*)", possui conceitos "([^"]*)", "([^"]*)" e "([^"]*)" em "([^"]*)"$/) { String aluno, String login, String conceito1, String conceito2, String conceito3, String materia ->
    // Write code here that turns the phrase above into concrete actions
    AddStudentsTestDataAndOperations.createStudent(aluno, login)
    studentToCheck = Student.findByLogin(login)
    assert studentToCheck.login.equals(login)
    assert studentToCheck.name.equals(aluno)
    CriterionTestDataAndOperations.createCriterion(materia)
    assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito1, materia, "Form", "10/10/2016", login)
    assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito2, materia, "Mini-Test", "09/10/2016", login)
    assert CommonTestDataAndOperations.giveEvaluationToCriterion(conceito3, materia, "Test", "11/10/2016", login)
}
And(~/^o aluno "([^"]*)", possui media "([^"]*)" em "([^"]*)"$/) { String aluno, Double media, String conceito ->
    Student estudante = Student.findByName(aluno)
    estudante.calcMedia()
    assert(estudante.findEvaluationByCriterion(conceito).criterionAverage.equals(media))
}
When(~/^eu solicito a situação do aluno "([^"]*)"$/) { String aluno ->
    Student estudante = Student.findByName(aluno)
    criteriosLista = estudante.getCriteriaAndEvaluations()
}
Then(~/^a média de "([^"]*)" em "([^"]*)" continua sendo "([^"]*)"$/) { String aluno, String conceito, Double media ->
    assert(Student.findByName(aluno).getCriteriaAndEvaluations().equals(criteriosLista))
    assert(Student.findByName(aluno).findEvaluationByCriterion(conceito).criterionAverage.equals(media))
}
Given(~/^o aluno "([^"]*)", com login "([^"]*)", possui média "([^"]*)" em "([^"]*)"$/) { String aluno, String login, String media, String conceito ->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(aluno, login)
    page.selectAddStudent()
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(conceito)
    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseCriterion(conceito)
    if(media.equals("9")){
        page.chooseValue("MA")
    }
    page.selectAddEvaluation()
}
When(~/^eu solicito a página "([^"]*)"$/) { String pagina ->
    if(pagina.equals("SituationStudentPage")){
        to SituationStudentPage
        at SituationStudentPage
    }
}
Then(~/^a média do aluno de login "([^"]*)" em "([^"]*)" aparece verde e com uma seta para cima$/) { String aluno, String conceito ->
        assert page.mediaVerde(aluno, conceito)
}

Given(~/^o aluno "([^"]*)", com login "([^"]*)", possui media "([^"]*)" em "([^"]*)"$/) { String aluno, String login, String media, String conceito ->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(aluno, login)
    page.selectAddStudent()
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(conceito)
    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseCriterion(conceito)
    if(media.equals("3")){
        page.chooseValue("MANA")
    }
    page.selectAddEvaluation()
}

Then(~/^a média do aluno de login "([^"]*)" em "([^"]*)" aparece vermelho e com uma seta para baixo$/) { String aluno, String conceito ->
    to SituationStudentPage
    at SituationStudentPage
    assert page.mediaVermelha(aluno,conceito)
}