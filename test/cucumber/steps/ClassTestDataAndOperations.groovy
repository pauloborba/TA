package steps

import ta.Aluno
import ta.AlunoController
import ta.Avaliacao
import ta.Matricula
import ta.MatriculaController
import ta.Meta
import ta.MetaController
import ta.PlanilhaAvaliacao
import ta.PlanilhaFactory
import ta.Resultado
import ta.Turma
import ta.TurmaController

class ClassTestDataAndOperations {

    static boolean procurarAvaliacaoByMatricula(Matricula matricula, String conceito, String meta){
        List<Avaliacao> listaAvaliacoes = matricula.avaliacoes
        def achou = false
        listaAvaliacoes.each { a ->
            String nomeMeta = a.meta.nome
            String nomeConceito = a.conceito

            if (nomeMeta.equalsIgnoreCase(meta) && nomeConceito.equalsIgnoreCase(conceito)){
                achou = true
            }
        }
        return achou
    }

    static boolean alunoTemConceitoNaMeta(String path, Meta meta, String conceito, String loginCin){
        //verificando se o aluno tem mesmo aquele conceito na planilha
        PlanilhaAvaliacao avaliacoes = PlanilhaFactory.getPlanilha(path, "avaliacao")

        def existeMeta = false
        def indexMeta
        def titulos = avaliacoes.getTitulosPlanilha()

        for(int i=0; i<titulos.size(); i++){
            if(titulos.get(i).equalsIgnoreCase(meta.nome)){
                existeMeta = true
                indexMeta = i
            }
        }

        def existeAlunoConceito = false
        for(int i=1; i<avaliacoes.sizeLinha; i++){

            String login = avaliacoes.getLinha(i).get(0)
            String conceitoLogin = avaliacoes.getLinha(i).get(indexMeta)

            if(login.equalsIgnoreCase(loginCin) && conceito.equalsIgnoreCase(conceitoLogin)){
                existeAlunoConceito = true
            }
        }

        return (existeAlunoConceito && existeMeta)
    }

    static Meta criarMeta(String nomeMeta){
        //cria uma meta no sistema com o nome da meta
        MetaController controladorMeta = new MetaController()
        controladorMeta.salvar(nomeMeta)

        return Meta.findByNome(nomeMeta)
    }

    static Turma criarTurma(String nomeTurma){
        TurmaController turmaController = new TurmaController()
        turmaController.salvar(nomeTurma)

        return Turma.findByNome(nomeTurma)
    }

    static void criarAlunosNaTurma(Turma turma, PlanilhaAvaliacao avaliacoes){

        //Criando estudantes no sistema com os logins da planilha
        def logins = avaliacoes.logins

        AlunoController alunoController = new AlunoController()
        MatriculaController matriculaController = new MatriculaController()

        for(int i=0; i< logins.size(); i++) {
            Aluno aluno = new Aluno(logins.get(i), logins.get(i), logins.get(i), logins.get(i),)
            aluno.save flush: true

            assert alunoController.alunoExiste(logins.get(i)) //sai do teste se nao conseguir criar o estudante

            Matricula m =  matriculaController.salvar(aluno)
            turma.matriculas.add(m)
        }
    }

    static Matricula matriculaByAluno(String loginCin){
        Aluno aluno = Aluno.findByLoginCin(loginCin)
        return Matricula.findByAluno(aluno)
    }

    static File arquivo(String arquivo){
        //path para teste
        def defaultPathBase = new File( "." ).getCanonicalPath()
        println ("Current dir: " + defaultPathBase + "/test/resources/" + arquivo)
        def path = defaultPathBase + "/test/resources/" + arquivo

        //existe uma planilha
        return new File(path)
    }

    static void deletarTudo(){
        apagarListas(Aluno.list())
        apagarListas(Avaliacao.list())
        apagarListas(Matricula.list())
        apagarListas(Meta.list())
        apagarListas(Resultado.list())
        apagarListas(Turma.list())
    }

    static void apagarListas(List l) {
        l.each { e ->
            e.delete(flush: true)
        }
    }


}
