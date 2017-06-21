import cucumber.api.PendingException
import steps.ComparaTurmasTestDataAndOperations
import ta.Matricula
import ta.Turma
import ta.Aluno

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


Given(~/^eu tenho a turma "([^"]*)"$/) { String nome ->
    ComparaTurmasTestDataAndOperations.createTurma(nome)
    assert ComparaTurmasTestDataAndOperations.getTurma(nome) != null
}

And(~/^"([^"]*)" possui media final "([^"]*)"$/) { String nomeA, double nota ->
    Aluno a = ComparaTurmasTestDataAndOperations.getAluno(nomeA)
    a.media = nota
}

And(~/^o aluno "([^"]*)" esta matriculado em "([^"]*)"$/) { String nomeA, nomeT ->



    ComparaTurmasTestDataAndOperations.createAluno(nomeA)
    assert ComparaTurmasTestDataAndOperations.getAluno(nomeA) != null
    ComparaTurmasTestDataAndOperations.insereEmTurma(nomeA,nomeT)
}


When(~/^eu seleciono a turma "([^"]*)"$/) { String nome ->
    Turma.findByNome(nome)
}

Then(~/^a media geral de "([^"]*)" e calculada$/) { String arg1 ->

}

Then(~/^eu consigo ver a media geral de "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions

}

Given(~/^eu estou na pagina de "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    }

Then(~/^o numero de turmas que possuem media geral, numero percentual de alunos aprovados e numeros percentual de alunos aprovados por media inferior a "([^"]*)" e calculado$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions

}


Then(~/^eu consigo ver o numero de turmas que "([^"]*)" supera em questão de media geral, numero percentual de alunos aprovados e numeros percentual de alunos aprovados por media em comparacao com o total de turmas cadastradas$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
}