package steps

import ta.Turma
import ta.TurmaController

/**
 * Created by dquei on 9/29/2016.
 */
class ClassTestDataAndOperations {


    public static void createClass(String id, per) {
        def controller = new TurmaController()
        controller.params << [classID: id, periodo: per]
        controller.createAndSaveTurma()
        controller.response.reset()
    }

    public static Turma getTurma(String id, String peri) {
        def controller = new TurmaController()
        controller.params << [classID: id, periodo: peri]
        return controller.getTurma()
    }

    public static boolean compatibleTo(String id, String peri, Turma cl) {
        if (id == cl.classID && peri == cl.periodo) return true
        return false
    }

    public static boolean onlyTurma(String id, String peri) {
        def controller = new TurmaController()
        controller.params << [classID: id, periodo: peri]
        return controller.onlyTurma()
    }
}
