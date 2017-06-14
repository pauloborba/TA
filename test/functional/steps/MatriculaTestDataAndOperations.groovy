package steps

import ta.Aluno
import ta.Avaliacao
import ta.Matricula
import ta.MatriculaController
import ta.Turma

/**
 * Created by rrms on 13/06/2017.
 */
class MatriculaTestDataAndOperations {
    public static void criarMatricula(Aluno aluno){
        def matriculaController = new MatriculaController()
        matriculaController.params << [aluno: aluno]
        matriculaController.createAndSaveMatricula()
        matriculaController.response.reset()
    }

    public static Matricula getMatricula(Aluno aluno) {
        def controller = new MatriculaController()
        controller.params << [aluno: aluno]
        return controller.getMatricula()
    }

    public static boolean compatibleTo(Aluno aluno, Turma turma, Matricula matricula) {
        if (aluno == matricula.aluno &&  turma == matricula.turma) return true
        return false
    }

    public static void addAvaliacao(Aluno aluno, Avaliacao avaliacao) {
        def controller = new MatriculaController()
        Matricula matricula = controller.getMatricula()
        matricula.avaliacoes.add(avaliacao)
        controller.params << [aluno: aluno, avaliacoes:matricula.avaliacoes]

        controller.updateMatricula()
    }



    public static int countMatricula(){
        def matriculaController = new MatriculaController()
        return matriculaController.count()
    }
}
