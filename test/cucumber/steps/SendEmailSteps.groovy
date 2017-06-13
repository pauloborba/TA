import ta.Avaliacao
import ta.AvaliacaoController
import ta.MatriculaController
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
    def alunoController = new AlunoController()
    def turmaController = new TurmaController()
    def matriculaController = new MatriculaController()

    criarAluno(nomeAluno,alunoController)
    Aluno aluno = Aluno.findByNome(nomeAluno)

    criarTurma(nomeTurma,turmaController)
    Turma turma = Turma.findByNome(nomeTurma)

    criarMatricula(aluno, turma, matriculaController)
    Matricula matricula = Matricula.findByAluno(aluno)

    assert aluno!=null
}

And(~'^o aluno "([^"]*)" tem conceito "([^"]*)" na meta "([^"]*)" e conceito "([^"]*)" na meta "([^"]*)" na avaliação "([^"]*)"$'){
    String nomeAluno, String conceito1, String meta1, String conceito2, String meta2, String nomeAvaliacao->
        def avaliacaoController = new AvaliacaoController()
        def resultadoController = new ResultadoController()
        def matriculaController = new MatriculaController()

        criarAvaliacao(nomeAvaliacao,avaliacaoController)
        Avaliacao avaliacao = Avaliacao.findByNome(nomeAvaliacao)

        criarResultado(conceito1,meta1, avaliacao, resultadoController)
        criarResultado(conceito2,meta2, avaliacao, resultadoController)

        Aluno aluno = Aluno.findByNome(nomeAluno)
        Matricula matricula = Matricula.findByAluno(aluno)
        matricula.avaliacoes.add(avaliacao)
        atualizaMatricula(matricula,matriculaController)

        assert matricula.avaliacoes.contains(avaliacao)
        assert avaliacao.resultados.size() == 2
        Resultado resultado1 = avaliacao.resultados.get(0)
        Resultado resultado2 = avaliacao.resultados.get(1)
        assert resultado1.meta.nome == meta1 && resultado1.conceito.nome == conceito1
        assert resultado2.meta.nome == meta2 && resultado2.conceito.nome == conceito2
}

And(~'^o sistema tem o aluno "([^"]*)" matriculado na turma "([^"]*)"$'){
    String nomeAluno, String nomeTurma ->
        def alunoController = new AlunoController()
        def turmaController = new TurmaController()
        def matriculaController = new MatriculaController()

        criarAluno(nomeAluno,alunoController)
        Aluno aluno = Aluno.findByNome(nomeAluno)

        criarTurma(nomeTurma,turmaController)
        Turma turma = Turma.findByNome(nomeAluno)

        criarMatricula(aluno, turma, matriculaController)
        Matricula matricula = Matricula.findByAluno(aluno)

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


def criarResultado(String conceito, String meta, ResultadoController resultadoController) {
    resultadoController.params << [conceito: conceito, meta: meta]
    resultadoController.save()
    resultadoController.response.reset()
}

def criarAvaliacao(String nome, AvaliacaoController avaliacaoController) {
    avaliacaoController.params << [nome: nome]
    avaliacaoController.save()
    avaliacaoController.response.reset()
}

def atualizaAvaliacao(Avaliacao avaliacao, AvaliacaoController avaliacaoController) {
    avaliacaoController.update(avaliacao)
    avaliacaoController.response.reset()
}

def criarTurma(String nome, TurmaController turmaController) {
    turmaController.params << [nome: nome]
    turmaController.save()
    turmaController.response.reset()
}

def atualizaTurma(Turma turma, TurmaController turmaController) {
    turmaController.update(turma)
    turmaController.response.reset()
}

def criarMatricula(Aluno aluno, Turma turma, MatriculaController matriculaController) {
    matriculaController.params << [aluno: aluno, turma:turma]
    matriculaController.save()
    matriculaController.response.reset()
}

def atualizaMatricula(Matricula matricula, MatriculaController matriculaController) {
    matriculaController.update(matricula)
    matriculaController.response.reset()
}


def criarAluno(String nome, AlunoController alunoController) {
    alunoController.params << [nome: nome]
    alunoController.save()
    alunoController.response.reset()
}
