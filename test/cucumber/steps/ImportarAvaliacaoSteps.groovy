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

Given(~/^existe uma planilha "([^"]*)" com os conceitos da meta "([^"]*)" de um "([^"]*)" da turma "([^"]*)"$/) { String pathPlanilha, String meta, String origem, String turma ->

    //existe uma planilha
    File file =  new File(pathPlanilha)
    assert file.exists() // se nao existir o arquivo sai do teste

    pathGlobal = pathPlanilha
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
    assert avaliacoes.metaExiste(meta) // se nao exister o conceito na planilha sai do teste

    //criando alunos na turma
    ClassTestDataAndOperations.criarAlunosNaTurma(turmaGlobal, avaliacoes)

}
And(~/^o aluno "([^"]*)" tem o conceito "([^"]*)"$/) { String aluno, String conceito ->

    assert ClassTestDataAndOperations.alunoTemConceitoNaMeta(pathGlobal, metaGlobal, conceito, aluno)

}
When(~/^eu tento salvar as avaliações com os conceitos da meta "([^"]*)" do "([^"]*)"$/) { String meta, String origem ->

    AvaliacaoController avaliacaoController = new AvaliacaoController()
    avaliacaoController.salvarAvaliacoesAux(pathGlobal, turmaGlobal, origemAvaliacaoGlobal)

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



