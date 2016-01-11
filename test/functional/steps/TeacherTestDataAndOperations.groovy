package steps

import ta.Teachers
import ta.TeachersController

class TeacherTestDataAndOperations {

    public static boolean createTeacher(String name, String cpf){
        def controller = new TeachersController()
        controller.params << [name: name] << [cpf: cpf]
        boolean saved = controller.saveTeacher(controller.createTeacher())
        controller.response.reset()
        return saved
    }

    public static boolean editCpf(String oldCpf, String newCpf){}

}