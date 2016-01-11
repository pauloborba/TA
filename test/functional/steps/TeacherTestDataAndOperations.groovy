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

    public static boolean editCpf(String name, String oldCpf, String newCpf){
        def controller = new TeachersController()
        controller.deleteTeacher(oldCpf)
        return createTeacher(name, newCpf)
    }

    public static boolean editName(String cpf, String newName){
        def controller = new TeachersController()
        controller.deleteTeacher(cpf)
        return createTeacher(newName, cpf)
    }

    public static boolean deleteTeacher(String cpf){
        boolean res = true
        def controller = new TeachersController()
        controller.deleteTeacher(cpf)
        return res
    }

}