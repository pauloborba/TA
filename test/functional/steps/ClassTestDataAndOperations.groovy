package steps

import ta.Turma
import ta.TurmaController

/**
 * Created by dquei on 9/29/2016.
 */
class ClassTestDataAndOperations {


    public static void createClass(String id, per) {
        def controller = new TurmaController()
        controller.params << [ClassID: id, periodo: per]
        controller.save()
        controller.response.reset()
    }

    public static Turma getTurma(String id, String peri) {
        def controller = new TurmaController()
        controller.params << [classID: id, periodo: peri]
        return controller.getTurma(id, peri)
    }

    public static boolean compatibleTo(String id, String peri, Turma cl) {
        if (id == cl.classID && peri == cl.periodo) return true
        return false
    }
}
