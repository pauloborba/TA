package steps

import pages.*

/**
 * Created by Sentinela on 21/11/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Nenhuma turma cadastrada
Given(~/^O sistema não tem nenhuma turma cadastrada$/) { ->
    to TurmasPage
    at TurmasPage

    assert $('#list-turma table tr').size() == 1
}
When(~/^Eu tento visualizar o relatórios e o gráfico das turmas$/) { ->
    to ReportingClassesPage
}
Then(~/^Nenhuma turma será listada$/) { ->
    at ReportingClassesPage

    assert page.classesNotList()

}

// Scenario: Média da turma
Given(~/^O sistema possui o aluno "([^"]*)" com login "([^"]*)"$/) {
    String name, String login ->

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails(name, login)
        page.selectAddStudent()

}
And(~/^O aluno "([^"]*)" com login "([^"]*)"$/) {
    String name, String login ->

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails(name, login)
        page.selectAddStudent()

}
And(~/^Possui um critério de nome "([^"]*)"$/) {
    String name ->

        to CreateCriterionPage
        at CreateCriterionPage
        page.createCriterion(name)

}
And(~/^O Student1 possui uma avaliação "([^"]*)" e o Student possui MA$/) {
    String average ->

        to AddEvaluationPage
        at AddEvaluationPage
        page.chooseValue(average)
        page.selectAddEvaluation()

}
And(~/^A turma "([^"]*)" de "([^"]*)" contém o aluno "([^"]*)" e o "([^"]*)"$/) {
    String name, String period, String login1, String login2 ->

        to CreateTurmaPage
        at CreateTurmaPage
        page.fillTurmaDetails(name, period)
        $('select', name: 'students').find("option").find{it.text().equals(login1)}.click()
        $('select', name: 'students').find("option").find{it.text().equals(login2)}.click()
        page.selectCreateTurma()

}
When(~/^Eu visualizo o relatório da turma cadastrada$/) { ->
    to ReportingClassesPage
}
Then(~/^A turma "([^"]*)" possuirá a média "([^"]*)"$/) {
    String _class, String average ->

        at ReportingClassesPage

        assert page.confirmAverage(_class, average);

}

// Scenario: Sinalização de média baixa
Given(~/^O sistema tem a turma "([^"]*)" de "([^"]*)" cadastradas com o aluno "([^"]*)"$/) {
    String name, String period, String login ->

        to CreateTurmaPage
        at CreateTurmaPage
        page.fillTurmaDetails(name, period)
        $('select', name: 'students').find("option").find{it.text().equals(login)}.click()
        page.selectCreateTurma()

}
And(~/^Recria o critério de nome "([^"]*)"$/) {
    String name ->

        to CreateCriterionPage
        at CreateCriterionPage
        page.createCriterion(name)

}
And(~/^Reavalia o estudante Student1 com "([^"]*)" e o Student com MA$/) {
    String average ->

        to AddEvaluationPage
        at AddEvaluationPage
        page.chooseValue(average)
        page.selectAddEvaluation()

}
When(~/^Eu visualizo o relatório das turmas$/) { ->
    to ReportingClassesPage
}
Then(~/^A turma "([^"]*)" estará com o plano de fundo vermelho$/) {
    String _class ->

        at ReportingClassesPage

        assert page.backgroundRed(_class);

}

// Scenario: Geração de gráfico
Given(~/^Que o sistema possui pelo menos uma turma cadastrada$/) { ->
    to TurmasPage
    at TurmasPage

    assert $('#list-turma table tr').size() > 1
}
When(~/^Eu visualizo o gráfico de turmas$/) { ->
    to ReportingClassesPage
}
Then(~/^Será gerado um gráfico$/) { ->
    at ReportingClassesPage

    assert page.classGraph();
}