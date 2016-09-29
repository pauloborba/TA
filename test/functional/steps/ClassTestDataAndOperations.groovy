package steps

import ta.Class
import ta.ClassController

/**
 * Created by dquei on 9/29/2016.
 */
class ClassTestDataAndOperations {


    public static void createClass(String id, per) {
        def controller = new ClassController()
        controller.params << [ClassID: id, periodo: per]
        controller.createAndSaveClass()
        controller.response.reset()
    }

    public static Class get_Class(String id, String peri) {
        def controller = new ClassController()
        controller.params << [classID: id, periodo: peri]
        return controller.get_Class()
    }

    public static boolean compatibleTo(String id, String peri, Class cl) {
        if (id.equals(cl.classID) && peri.equals(cl.periodo)) return true
        return false
    }
}
