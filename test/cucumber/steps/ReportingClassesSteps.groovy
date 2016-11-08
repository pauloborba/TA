package steps

import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.ReportingClassesPage

/**
 * Created by Sentinela on 07/11/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Scenario: Nenhuma turma cadastrada
Given(~/^O sistema não tem nenhuma turma cadastrada$/) { ->
    to ReportingClassesPage
    at ReportingClassesPage

    assert TA.Turma.list().size() == 0
}
When(~/^Eu tento visualizar o relatórios e o gráfico das turmas$/) { ->
    to ReportingClassesPage
    at ReportingClassesPage

}
Then(~/^Nenhuma turma será listada$/) {
    to ReportingClassesPage
    at ReportingClassesPage

    assert $('#list-reportingClasses table tr').size() == 0
}


// Scenario: Uma única turma cadastrada
Given(~/^O sistema tem apenas a turma "([^"]*)" cadastrada$/) { String turma ->
    to ReportingClassesPage
    at ReportingClassesPage

    assert TA.Turma.list().size() == 0
    assert TA.Turma.list().get(0).periodo == turma
}
When(~/^Eu tento fazer uma comparação somente com a turma "([^"]*)"$/) { String turma ->
    at ReportingClassesPage

    page.selectClass(turma)
}
Then(~/^Não será permitida fazer a comparação somente com a turma "([^"]*)"$/) { String turma ->
    at ReportingClassesPage

    assert $("input", name: "compare").attr("disabled") == 'disabled'
}


// Scenario: Várias turmas cadastradas
Given(~/^O sistema tem as turmas "([^"]*)", "([^"]*)" e "([^"]*)" cadastradas$/) {
    String class0, class1, class2 ->

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student1', 'student1@cin.ufpe.br')
        page.selectAddStudent()

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student2', 'student2@cin.ufpe.br')
        page.selectAddStudent()

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student3', 'student3@cin.ufpe.br')
        page.selectAddStudent()

        to CreateCriterionPage
        at CreateCriterionPage
        page.createCriterion('Criterion1')

        to AddEvaluationPage
        at AddEvaluationPage
        page.setEvaluationToStudent('student1@cin.ufpe.br', 'MA')
        page.setEvaluationToStudent('student2@cin.ufpe.br', 'MPA')
        page.setEvaluationToStudent('student3@cin.ufpe.br', 'MANA')
        page.selectAddEvaluation()

        to CreateClassPage
        at CreateClassPage
        page.createClass(class0, class0, 'student1@cin.ufpe.br')
        page.createClass(class1, class1, 'student2@cin.ufpe.br')
        page.createClass(class2, class2, 'student3@cin.ufpe.br')

}
When (~/^Eu irei fazer uma comparação entre a turma "([^"]*)" com média "([^"]*)" e "([^"]*)" com média "([^"]*)"$/) {
    String class0, average0, class1, average1 ->
        to ReportingClassesPage
        at ReportingClassesPage

        page.selectClass(class0, average0)
        page.selectClass(class1, average1)
        $("input", name: "compare").click()
}
Then (~/^Será exibido um relatório onde informa que a turma "([^"]*)" teve uma diferença de "([^"]*)" em relação a turma "([^"]*)"$/) {
    String class0, value, class1 ->
        at ReportingClassesPage

        assert $('#alertContent').text() == "The class \"$class0\" has a \"$value%\" difference from the class \"$class1\""
}


// Comparar mais de duas turmas simultaneamente
Given(~/^O sistema tem as turmas "([^"]*)", "([^"]*)" e "([^"]*)" previamente cadastradas$/) {
    String class0, class1, class2 ->

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student1', 'student1@cin.ufpe.br')
        page.selectAddStudent()

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student2', 'student2@cin.ufpe.br')
        page.selectAddStudent()

        to AddStudentsPage
        at AddStudentsPage
        page.fillStudentDetails('Student3', 'student3@cin.ufpe.br')
        page.selectAddStudent()

        to CreateCriterionPage
        at CreateCriterionPage
        page.createCriterion('Criterion1')

        to AddEvaluationPage
        at AddEvaluationPage
        page.setEvaluationToStudent('student1@cin.ufpe.br', 'MA')
        page.setEvaluationToStudent('student2@cin.ufpe.br', 'MPA')
        page.setEvaluationToStudent('student3@cin.ufpe.br', 'MANA')
        page.selectAddEvaluation()

        to CreateClassPage
        at CreateClassPage
        page.createClass(class0, class0, 'student1@cin.ufpe.br')
        page.createClass(class1, class1, 'student2@cin.ufpe.br')
        page.createClass(class2, class2, 'student3@cin.ufpe.br')

}
When (~/^Eu tento comparar as turmas "([^"]*)", "([^"]*)" e "([^"]*)" simultaneamente$/) {
    String class0, class1, class2 ->
        to ReportingClassesPage
        at ReportingClassesPage

        page.selectClass(class0)
        page.selectClass(class1)
        page.selectClass(class2)

}
Then (~/^Não será permitida a seleção da turma "([^"]*)"$/) {
    String _class ->
        at ReportingClassesPage

        assert checkClassSelected(_class)
        assert $('#alertContent').text() == "You can only compare two classes at a time"
}