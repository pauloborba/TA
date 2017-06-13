package steps

import ta.Class
import ta.ClassController

/**
 * Created by Avell on 13/06/2017.
 */
class ClassTestDataAndOperations {

    public static void createClass(String id, per) {
        def controller = new ClassController()
        controller.params << [classID: id, periodo: per]
        controller.createAndSaveClass()
        controller.response.reset()
    }

    public static Class get_Class(String id, String periodo) {
        def controller = new ClassController()
        controller.params << [classID: id, periodo: periodo]
        return controller.get_Class()
    }

    public static boolean compatibleTo(String id, String periodo, Class cl) {
        if (id == cl.classID && periodo == cl.periodo) return true
        return false
    }

    public static boolean onlyClass(String id, String period){
        def cont = new ClassController()
        cont.params << [classID: id, periodo: period]
        return cont.onlyClass()
    }
}
