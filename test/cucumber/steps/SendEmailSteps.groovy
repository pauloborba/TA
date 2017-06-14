import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import pages.EnviarEmailAutoAvaliacao

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

import pages.EnviarEmailComProblemasPage
import pages.ShowTurmaPage
import pages.TurmasPage
import steps.AlunoTestDataAndOperations
import steps.AvaliacaoTestDataAndOperations
import steps.MetaTestDataAndOperations
import steps.ResultadoTestDataAndOperations
import steps.TurmaTestDataAndOperations
import steps.MatriculaTestDataAndOperations
import ta.Avaliacao
import ta.EnviarEmailController
import ta.Meta
import ta.Aluno
import ta.Turma
import ta.Matricula
import ta.Resultado

/**
 * Created by Ricardo on 5/11/2017.
 */




Given(~'^que o sistema tem o aluno "([^"]*)" matriculado na turma "([^"]*)"$'){ String nomeAluno, String nomeTurma ->
        AlunoTestDataAndOperations.criarAluno(nomeAluno)
        Aluno aluno = AlunoTestDataAndOperations.getAluno(nomeAluno)

        MatriculaTestDataAndOperations.criarMatricula(aluno)
        Matricula matricula = MatriculaTestDataAndOperations.getMatricula(aluno)

        TurmaTestDataAndOperations.criarTurma(nomeTurma)
        Turma turma = TurmaTestDataAndOperations.getTurma(nomeTurma)

        TurmaTestDataAndOperations.matricular(turma,matricula)

        assert turma.matriculas.contains(matricula)
}

And(~'^o aluno "([^"]*)" tem conceito "([^"]*)" na meta "([^"]*)" e conceito "([^"]*)" na meta "([^"]*)" na avaliação "([^"]*)"$'){
    String nomeAluno, String conceito1, String meta1, String conceito2, String meta2, String nomeAvaliacao->

        Aluno aluno = AlunoTestDataAndOperations.getAluno(nomeAluno)
        Matricula matricula = MatriculaTestDataAndOperations.getMatricula(aluno)

        AvaliacaoTestDataAndOperations.criarAvaliacao(nomeAvaliacao, matricula)
        Avaliacao avaliacao = AvaliacaoTestDataAndOperations.getAvaliacao(nomeAvaliacao,matricula)

        MetaTestDataAndOperations.criarMeta(meta1)
        Meta metaAux1 = MetaTestDataAndOperations.getMeta(meta1)

        MetaTestDataAndOperations.criarMeta(meta2)
        Meta metaAux2 = MetaTestDataAndOperations.getMeta(meta2)

        ResultadoTestDataAndOperations.criarResultado(conceito1, metaAux1,avaliacao)
        ResultadoTestDataAndOperations.criarResultado(conceito2,metaAux2,avaliacao)

        MatriculaTestDataAndOperations.addAvaliacao(aluno,avaliacao)


        assert matricula.avaliacoes.contains(avaliacao)
        assert avaliacao.resultados.size() == 2

        Resultado resultado1 = (Resultado) avaliacao.resultados.get(0)
        Resultado resultado2 = (Resultado) avaliacao.resultados.get(1)

        assert resultado1.meta.nome == meta1 && resultado1.conceito == conceito1
        assert resultado2.meta.nome == meta2 && resultado2.conceito == conceito2
}


And(~'^o sistema tem o aluno "([^"]*)" matriculado na turma "([^"]*)"$'){
    String nomeAluno, String nomeTurma ->
        AlunoTestDataAndOperations.criarAluno(nomeAluno)
        Aluno aluno = AlunoTestDataAndOperations.getAluno(nomeAluno)

        MatriculaTestDataAndOperations.criarMatricula(aluno)
        Matricula matricula = MatriculaTestDataAndOperations.getMatricula(aluno)

        TurmaTestDataAndOperations.criarTurma(nomeTurma)
        Turma turma = TurmaTestDataAndOperations.getTurma(nomeTurma)

        TurmaTestDataAndOperations.matricular(turma,matricula)

        assert turma.matriculas.contains(matricula)
}


When(~'^eu solicitar o envio de email para alunos com problemas para a turma "([^"]*)"$'){
    String nomeTurma ->
        EnviarEmailController.enviarAlunosComProblemas(nomeTurma)
}

Then(~'^será enviado um email para os alunos "([^"]*)" e "([^"]*)" da turma "([^"]*)", apenas$') {
    String nomeAluno1, String nomeAluno2, String nomeTurma->
        List alunos = EnviarEmailController.enviarAlunosComProblemas(nomeTurma)
        assert alunos.size() == 2
        assert alunos.contains(Aluno.findByNome(nomeAluno1))
        assert alunos.contains(Aluno.findByNome(nomeAluno2))
}


When(~'^eu solicitar o envio de email de autoavaliação para a turma "([^"]*)"$'){
    String nomeTurma ->
        EnviarEmailController.enviarAutoavaliacao(nomeTurma)
}

Then(~'^será enviado um email com link de autoavaliação para os alunos email "([^"]*)", o aluno "([^"]*)" e o aluno "([^"]*)" da turma "([^"]*)"$') {
    String nomeAluno1, String nomeAluno2, String nomeAluno3, String nomeTurma->
        List alunos = EnviarEmailController.enviarAutoavaliacao(nomeTurma)
        assert alunos.size() == 3
        assert alunos.contains(Aluno.findByNome(nomeAluno1))
        assert alunos.contains(Aluno.findByNome(nomeAluno2))
        assert alunos.contains(Aluno.findByNome(nomeAluno3))
}


Given(~'^que eu estou na pagina de visualizar as turmas e tenho a turma "([^"]*)" cadastrada$'){
    String nomeTurma ->
        TurmaTestDataAndOperations.criarTurma(nomeTurma)
        to TurmasPage
        at TurmasPage

}

When(~/^eu seleciono a turma "([^"]*)"$/) {
    String nomeTurma ->
        at TurmasPage
        page.selecionaTurma(nomeTurma)
}

And(~'^eu escolho enviar email para alunos com problemas na turma "([^"]*)"$') {
    String nomeTurma ->
        at ShowTurmaPage
        page.selecionaEnviarEmailAlunosComProblemas()
}

Then(~'^eu vejo a lista dos alunos com problemas da turma "([^"]*)" que receberam os emails$') {
    String ShowTurmaPage ->
        at EnviarEmailComProblemasPage
}

Then(~'^eu vejo a lista dos alunos da turma "([^"]*)" que receberam os emails de autoavaliacao$') {
    String ShowTurmaPage ->
        at EnviarEmailAutoAvaliacao
}



And(~'^eu escolho enviar email de autoavaliacao para alunos da turma "([^"]*)"$') {
    String nomeTurma ->
        at ShowTurmaPage
        page.selecionaEnviarEmailAutoAvaliacao()
}
