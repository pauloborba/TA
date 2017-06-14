package steps

import cucumber.api.PendingException
import sun.security.x509.AVA
import ta.AvaliacaoController
import ta.Matricula
import ta.Meta
import ta.PlanilhaAvaliacao
import ta.PlanilhaFactory
import ta.Turma

import pages.ImportarAvaliacoesPage
import pages.VisualizarAvaliacoesPage


/**
 * Created by Isaac Douglas on 28/05/17.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


String pathGlobal = null

Given(~/^existe uma planilha "([^"]*)" com os conceitos da meta "([^"]*)" de um "([^"]*)" da turma "([^"]*)"$/) { String planilha, String meta, String origem, String turma ->

    PlanilhaAvaliacao avaliacoes = planilhaAvaliacao(planilha)
    pathGlobal = avaliacoes.url

    //criando uma meta
    Meta m = ClassTestDataAndOperations.criarMeta(meta)
    assert m != null

    //cria uma turma
    Turma t = ClassTestDataAndOperations.criarTurma(turma)
    assert t != null

    //adicionando meta na turma
    t.metas.add(m)

    //verifica se na planilha existe os conceitos da meta
    assert avaliacoes.metaExiste(meta) // se nao existir o conceito na planilha sai do teste

    //criando alunos e matriculando na turma
    ClassTestDataAndOperations.criarAlunosNaTurma(t, avaliacoes)

}
And(~/^o aluno "([^"]*)" tem o conceito "([^"]*)" na meta "([^"]*)"$/) { String aluno, String conceito, String meta ->

    assert ClassTestDataAndOperations.alunoTemConceitoNaMeta(pathGlobal, Meta.findByNome(meta), conceito, aluno)

}
When(~/^eu tento salvar as avaliações com os conceitos da meta "([^"]*)" do "([^"]*)" da turma "([^"]*)"$/) { String meta, String origem, String turma ->

    salvarAvaliacoesConceitos(pathGlobal, turma, origem)

}
Then(~/^o aluno "([^"]*)" fica com o conceito "([^"]*)" na meta "([^"]*)"$/) { String login, String conceito, String meta ->

    Matricula matricula = ClassTestDataAndOperations.matriculaByAluno(login)

    //procurando se o aluno ficou com os dados corretos
    assert ClassTestDataAndOperations.procurarAvaliacaoByMatricula(matricula, conceito, meta)
}




Given(~/^eu estou na pagina Importar Avaliacoes$/) { ->
    to ImportarAvaliacoesPage
    at ImportarAvaliacoesPage
}
And(~/^eu seleciono a avaliacao "([^"]*)" para a turma "([^"]*)" e escolho a planilha "([^"]*)" para importar$/) { String origem, String turma, String planilha ->
    at ImportarAvaliacoesPage
    page.origem(origem)
    page.turma(turma)
}
Then(~/^eu consigo ver as avaliações salvas na pagina "([^"]*)"$/) { String pagina ->
    to VisualizarAvaliacoesPage
    at VisualizarAvaliacoesPage
}




Given(~/^existe uma planilha "([^"]*)" com os conceitos de varias metas de uma "([^"]*)" da turma "([^"]*)"$/) { String planilha, String origem, String turma ->

    PlanilhaAvaliacao avaliacoes = planilhaAvaliacao(planilha)
    pathGlobal = avaliacoes.url

    //criando varias metas
    avaliacoes.metas.each{ nomeMeta ->
        assert ClassTestDataAndOperations.criarMeta(nomeMeta) != null
    }

    //cria uma turma
    Turma t = ClassTestDataAndOperations.criarTurma(turma)
    assert t != null

    //adicionando metas na turma
    Meta.list().each { meta ->
        t.metas.add(meta)
    }

    //verifica se na planilha existe os conceitos das metas
    Meta.list().each { m ->
        assert avaliacoes.metaExiste(m.nome) // se nao existir o conceito na planilha sai do teste
    }

    //criando alunos e matriculando na turma
    ClassTestDataAndOperations.criarAlunosNaTurma(t, avaliacoes)

}

When(~/^eu tento salvar as avaliações com os conceitos de todas as metas da "([^"]*)" da turma "([^"]*)"$/) { String origem, String turma ->

    salvarAvaliacoesConceitos(pathGlobal, turma, origem)

}

PlanilhaAvaliacao planilhaAvaliacao(String planilha){
    File file = ClassTestDataAndOperations.arquivo(planilha)
    assert file.exists() // se nao existir o arquivo sai do teste

    return PlanilhaFactory.getPlanilha(file.path, "avaliacao")
}

def salvarAvaliacoesConceitos(String path, String turma, String origem){
    AvaliacaoController avaliacaoController = new AvaliacaoController()
    avaliacaoController.salvarAvaliacoesAux(path, Turma.findByNome(turma), origem)
}