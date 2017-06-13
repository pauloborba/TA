import steps.AlunoTestDataAndOperations
import steps.AvaliacaoTestDataAndOperations
import steps.MetaTestDataAndOperations
import steps.ResultadoTestDataAndOperations
import steps.TurmaTestDataAndOperations
import steps.MatriculaTestDataAndOperations
import ta.Avaliacao
import ta.AvaliacaoController
import ta.MatriculaController
import ta.Meta
import ta.ResultadoController
import ta.TurmaController
import ta.AlunoController
import ta.Aluno
import ta.Turma
import ta.Matricula
import ta.Resultado

/**
 * Created by Ricardo on 5/11/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)



Given(~'^que o sistema tem o aluno "([^"]*)" matriculado na turma "([^"]*)"$'){ String nomeAluno, String nomeTurma ->
        AlunoTestDataAndOperations.criarAluno(nomeAluno)
        Aluno aluno = AlunoTestDataAndOperations.getAluno(nomeAluno)

        TurmaTestDataAndOperations.criarTurma(nomeTurma)
        Turma turma = TurmaTestDataAndOperations.getTurma(nomeTurma)

        MatriculaTestDataAndOperations.criarMatricula(aluno, turma)
        Matricula matricula = MatriculaTestDataAndOperations.getMatricula(aluno)

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
        assert nomeAluno != null
        AlunoTestDataAndOperations.criarAluno(nomeAluno)
        Aluno aluno = AlunoTestDataAndOperations.getAluno(nomeAluno)

        TurmaTestDataAndOperations.criarTurma(nomeTurma)
        Turma turma = TurmaTestDataAndOperations.getTurma(nomeAluno)

        MatriculaTestDataAndOperations.criarMatricula(aluno, turma)
        Matricula matricula = MatriculaTestDataAndOperations.getMatricula(aluno)

        assert turma.matriculas.contains(matricula.aluno)
}








When(~'^eu solicitar o envio de email para alunos com problemas$'){
    EnviarEmail.enviarAlunosComProblemas()
}

Then(~'^será enviado um email para os alunos "([^"]*)" e "([^"]*)", apenas$') {
    String nomeAluno1, String nomeAluno2 ->
        List alunos = EnviarEmail.enviarAlunosComProblemas()
        assert alunos.size() == 2
        assert alunos.contains(Aluno.findByNome(nomeAluno1))
        assert alunos.contains(Aluno.findByNome(nomeAluno2))
}