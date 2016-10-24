package steps

import cucumber.api.PendingException
import pages.ReportsPages.CreateReportsPage
import steps.CriterionTestDataAndOperations
import steps.ReportsDataAndOperations
import ta.ReportController
import steps.AddStudentsTestDataAndOperations
import steps.StudentConsultTestDataAndOperations
import pages.ReportsPages.ShowReportsPage
import static steps.EvaluationDataAndOperations.*
import pages.ReportsPages.IndexReport

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

/**
 * #Victor Augusto Pereira Porciúncula - vapp
 */



Given(~/^a Média Final do aluno "([^"]*)" é igual a (\d+)$/) { String arg1, int arg2 ->
    to menuPrincipalPage
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 3, 7, arg2)       // cria-se o aluno com nome, manas avaliadas, mpas avaliadas, mas avaliadas e nota !! Tambem vai ter um construtor para a nota da final
}
And(~/^a Média Final da aluna "([^"]*)" é igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg2)   // aqui eh o construtor com a nota da final
}
And(~/^a Média Final do aluno "([^"]*)" é (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg2)   // aqui eh o construtor com a nota da final
}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeTotalDeAlunos(arg1)
}
And(~/^há um total de (\d+) critérios avaliados$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeCriteriosAvaliados(arg1)
}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->
    at menuPrincipalPage
    page.gerarRelatorio()
}
Then(~/^a linha do aluno "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->
    to relatorioAlunosPage
    at relatorioAlunosPage
    assert page.isColor(arg2, arg1)
}
And(~/^a coluna "([^"]*)" do aluno "([^"]*)" será vazia$/) { String arg1, String arg2 ->
    at relatorioAlunosPage
    assert page.isNull(arg1, arg1)
}
And(~/^a linha da aluna "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->
    at relatorioAlunosPage
    assert page.isColor(arg2, arg1)
}
And(~/^a linha do aluno "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->
    at relatorioAlunosPage
    assert page.isColor(arg2, arg1)
}



Given(~/^o aluno "([^"]*)" teve (\d+) MANAs Avaliadas, (\d+) MPAs Avaliadas e (\d+) MAs Avaliadas$/) { String arg1, int arg2, int arg3, int arg4 ->
    to menuPrincipalPage
    at menuPrincipalPage
    page.criarAluno(arg1, arg2, arg3, arg4, 9)
}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeTotalDeAlunos(arg1)
}
And(~/^há um total de (\d+) critérios avaliados$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeCriteriosAvaliados(arg1)
}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->
    at menuPrincipalPage
    page.gerarRelatorio()
}
Then(~/^a coluna "([^"]*)" do aluno "([^"]*)" será (\d+)$/) { String arg1, String arg2, String arg3 ->
    to relatorioAlunosPage
    at relatorioAlunosPage
    assert isColumn(arg1, arg2, arg3)
}



Given(~/^a aluna "([^"]*)" teve Nota igual a (\d+) e teve Final igual a (\d+)$/) { String arg1, int arg2, int arg3 ->
    to menuPrincipalPage
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg3)
}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeTotalDeAlunos(arg1)
}
And(~/^há um total de (\d+) critérios avaliados$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeCriteriosAvaliados(arg1)
}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->
    at menuPrincipalPage
    page.gerarRelatorio()
}
Then(~/^a aluna "([^"]*)" terá a a coluna "([^"]*)" igual a (\d+)$/) { String arg1, String arg2, int arg3 ->
    to relatorioAlunosPage
    at relatorioAlunosPage
    assert isColumn(arg2, arg1, arg3)
}




Given(~/^o aluno "([^"]*)" tem Média Final igual a (\d+)$/) { String arg1, int arg2 ->
    to menuPrincipalPage
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 3, 7, arg2)
}
And(~/^o aluno "([^"]*)" tem Média Final igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg2)
}
And(~/^o aluno "([^"]*)" tem Média Final igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg2)
}
And(~/^o aluno "([^"]*)" tem Média Final igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 5, 5, arg2, arg2)
}
And(~/^a aluna "([^"]*)" tem Média Final igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 0, 10, arg2)
}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeTotalDeAlunos(arg1)
}
And(~/^há um total de (\d+) critérios avaliados$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeCriteriosAvaliados(arg1)
}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->
    at menuPrincipalPage
    page.gerarRelatorio()
}
Then(~/^o "([^"]*)" será igual a (\d+)"$/) { String arg1, int arg2 ->
    to relatorioAlunosPage
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}
And(~/^o "([^"]*)" será igual a (\d+)$/) { String arg1, int arg2 ->
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}
And(~/^o "([^"]*)" será igual a (\d+)$/) { String arg1, int arg2 ->
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}
And(~/^o "([^"]*)" será igual a (\d+)$/) { String arg1, int arg2 ->
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}
And(~/^o "([^"]*)" será igual a (\d+)$/) { String arg1, int arg2 ->
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}




Given(~/^o número total de critérios cadastrados para a turma é (\d+)$/) { String arg1 ->
    to menuPrincipalPage
    at menuPrincipalPage
    page.quantidadeCriteriosAvaliados(arg1)
}
And(~/^a aluna "([^"]*)" tem Total de critérios avaliados igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 0, arg2, 6)
}
And(~/^a aluna "([^"]*)" tem Total de critérios avaliados igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 0, arg2, 10)
}
And(~/^o aluno "([^"]*)" tem Total de critérios avaliados igual a (\d+)$/) { String arg1, int arg2 ->
    at menuPrincipalPage
    page.criarAluno(arg1, 0, 0, arg2, 5)
}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->
    at menuPrincipalPage
    page.quantidadeTotalDeAlunos(arg1)
}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->
    at menuPrincipalPage
    page.gerarRelatorio()
}
Then(~/^o "([^"]*)" será igual a (\d+)$/) { String arg1, int arg2 ->
    at relatorioAlunosPage
    assert isGeneralColumn(arg1, arg2)
}