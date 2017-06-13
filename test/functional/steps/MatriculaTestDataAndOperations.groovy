package steps

import ta.Aluno
import ta.Matricula
import ta.MatriculaController
import ta.Turma

/**
 * Created by rrms on 13/06/2017.
 */
class MatriculaTestDataAndOperations {
    public static void criarMatricula(Aluno aluno, Turma turma){
        def matriculaController = new MatriculaController()
        matriculaController.params << [aluno: aluno, turma: turma]
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

    public static boolean onlyMatricula(Aluno aluno, Turma turma){
        def matriculaController = new MatriculaController()
        matriculaController.params << [aluno: aluno, turma: turma]
        return matriculaController.onlyMatricula()
    }

    public static int countMatricula(){
        def matriculaController = new MatriculaController()
        return matriculaController.onlyMatricula()
    }
}
