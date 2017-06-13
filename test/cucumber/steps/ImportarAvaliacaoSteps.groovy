package steps

import cucumber.api.PendingException
import sun.security.x509.AVA
import ta.AvaliacaoController
import ta.Matricula
import ta.Meta
import ta.PlanilhaAvaliacao
import ta.PlanilhaFactory
import ta.Turma


/**
 * Created by Isaac Douglas on 28/05/17.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


String pathGlobal = null
String origemAvaliacaoGlobal = null
Meta metaGlobal = null
Turma turmaGlobal = null

Given(~/^existe uma planilha "([^"]*)" com os conceitos da meta "([^"]*)" de um "([^"]*)" da turma "([^"]*)"$/) { String planilha, String meta, String origem, String turma ->

//    ClassTestDataAndOperations.deletarTudo()

    File file = ClassTestDataAndOperations.arquivo(planilha)
    assert file.exists() // se nao existir o arquivo sai do teste

    pathGlobal = file.path
    origemAvaliacaoGlobal = origem

    //criando uma meta
    metaGlobal = ClassTestDataAndOperations.criarMeta(meta)
    assert metaGlobal != null

    //cria uma turma
    turmaGlobal = ClassTestDataAndOperations.criarTurma(turma)
    assert turmaGlobal != null

    //adicionando meta na turma
    turmaGlobal.metas.add(metaGlobal)

    //verifica se na planilha existe os conceitos da meta
    PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(pathGlobal, "avaliacao")
    assert avaliacoes.metaExiste(meta) // se nao existir o conceito na planilha sai do teste

    //criando alunos e matriculando na turma
    ClassTestDataAndOperations.criarAlunosNaTurma(turmaGlobal, avaliacoes)

}
And(~/^o aluno "([^"]*)" tem o conceito "([^"]*)" na meta "([^"]*)"$/) { String aluno, String conceito, String meta ->

    assert ClassTestDataAndOperations.alunoTemConceitoNaMeta(pathGlobal, Meta.findByNome(meta), conceito, aluno)

}
When(~/^eu tento salvar as avaliações com os conceitos da meta "([^"]*)" do "([^"]*)"$/) { String meta, String origem ->

    AvaliacaoController avaliacaoController = new AvaliacaoController()
    avaliacaoController.salvarAvaliacoesAux(pathGlobal, turmaGlobal, origem)

}
Then(~/^o aluno "([^"]*)" fica com o conceito "([^"]*)" na meta "([^"]*)"$/) { String login, String conceito, String meta ->

    Matricula matricula = ClassTestDataAndOperations.matriculaByAluno(login)

    //procurando se o aluno ficou com os dados corretos
    assert ClassTestDataAndOperations.procurarAvaliacaoByMatricula(matricula, conceito, meta)
}




Given(~/^eu estou na pagina "([^"]*)"$/) { String arg1 ->


}
When(~/^eu salvo as avaliações da planilha "([^"]*)"$/) { String arg1 ->


}
Then(~/^eu consigo ver as avaliações salvas na pagina "([^"]*)"$/) { String arg1 ->


}




Given(~/^existe uma planilha "([^"]*)" com os conceitos de varias metas de uma "([^"]*)" da turma "([^"]*)"$/) { String planilha, String origem, String turma ->

//    ClassTestDataAndOperations.deletarTudo()

    File file = ClassTestDataAndOperations.arquivo(planilha)
    assert file.exists() // se nao existir o arquivo sai do teste

    pathGlobal = file.path
    origemAvaliacaoGlobal = origem

    PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(pathGlobal, "avaliacao")

    //criando varias metas
    avaliacoes.metas.each{ nomeMeta ->
        assert ClassTestDataAndOperations.criarMeta(nomeMeta) != null
    }

    //cria uma turma
    turmaGlobal = ClassTestDataAndOperations.criarTurma(turma)
    assert turmaGlobal != null

    //adicionando metas na turma
    Meta.list().each { meta ->
        turmaGlobal.metas.add(meta)
    }

    //verifica se na planilha existe os conceitos das metas
    Meta.list().each { m ->
        assert avaliacoes.metaExiste(m.nome) // se nao existir o conceito na planilha sai do teste
    }

    //criando alunos e matriculando na turma
    ClassTestDataAndOperations.criarAlunosNaTurma(turmaGlobal, avaliacoes)

}

When(~/^eu tento salvar as avaliações com os conceitos de todas as metas da "([^"]*)"$/) { String origem ->

    AvaliacaoController avaliacaoController = new AvaliacaoController()
    avaliacaoController.salvarAvaliacoesAux(pathGlobal, turmaGlobal, origem)

}
