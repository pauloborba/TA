package steps

import ta.Turma
import ta.TurmaController

/**
 * Created by rrms on 13/06/2017.
 */
class TurmaTestDataAndOperations {
    public static void criarTurma(String nomeTurma){
        def turmaController = new TurmaController()
        turmaController.params << [nome: nomeTurma]
        turmaController.createAndSaveTurma()
        turmaController.response.reset()
    }

    public static Turma getTurma(String nomeTurma) {
        def controller = new TurmaController()
        controller.params << [nome: nomeTurma]
        return controller.getTurma()
    }

    public static boolean compatibleTo(String nome, Turma turma) {
        if (nome == turma.nome ) return true
        return false
    }

    public static boolean onlyTurma(String nome){
        def turmaController = new TurmaController()
        turmaController.params << [nome: nome]
        return turmaController.onlyTurma()
    }

    public static int countTurma(){
        def turmaController = new TurmaController()
        return turmaController.onlyTurma()
    }
}
