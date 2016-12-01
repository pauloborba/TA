package steps

import cucumber.api.PendingException
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.SituationStudentPage


/**
 * Created by lavin on 29/11/2016.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


Given(~/^o aluno "([^"]*)", com login "([^"]*)", possui conceitos "([^"]*)", "([^"]*)" e "([^"]*)" em "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^o aluno "([^"]*)", possui media "([^"]*)" em "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^eu solicito a situação do aluno "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^a média de "([^"]*)" em "([^"]*)" continua sendo "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
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