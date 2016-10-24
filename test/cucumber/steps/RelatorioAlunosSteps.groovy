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





Given(~/^o item "([^"]*)" do aluno "([^"]*)" está vazio$/) { String arg1, String arg2 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^é mostrada uma mensagem indicando que ainda não foram cadastradas todas as notas no menu principal$/) { ->

}



Given(~/^a "([^"]*)" do aluno "([^"]*)" é igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^a "([^"]*)" da aluna "([^"]*)" é igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^a "([^"]*)" do aluno "([^"]*)" é "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^a linha do aluno "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->

}
And(~/^a coluna "([^"]*)" do aluno "([^"]*)" será vazia$/) { String arg1, String arg2 ->

}
And(~/^a linha da aluna "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->

}
And(~/^a linha do aluno "([^"]*)" será da cor "([^"]*)" no Relatório de notas$/) { String arg1, String arg2 ->

}




Given(~/^o aluno "([^"]*)" teve "([^"]*)" "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" teve "([^"]*)" "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" teve "([^"]*)" "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^a coluna "([^"]*)" do aluno "([^"]*)" será "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}




Given(~/^a aluna "([^"]*)" teve "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^a aluna "([^"]*)" teve "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^a aluna "([^"]*)" terá a a coluna "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}




Given(~/^o aluno "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^a aluna "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}
And(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}
And(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}
And(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}
And(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}




Given(~/^o número total de critérios cadastrados para a turma é "([^"]*)"$/) { String arg1 ->

}
And(~/^a aluna "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^a aluna "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^o aluno "([^"]*)" tem "([^"]*)" igual a "([^"]*)"$/) { String arg1, String arg2, String arg3 ->

}
And(~/^só há (\d+) alunos na turma$/) { int arg1 ->

}
When(~/^tento gerar o Relatório de notas no menu principal$/) { ->

}
Then(~/^o "([^"]*)" será igual a "([^"]*)"$/) { String arg1, String arg2 ->

}