package steps

import ta.Student
import ta.StudentController
import ta.Turma
import ta.TurmaController

/**
 * Created by dquei on 9/29/2016.
 */
class ClassTestDataAndOperations {


    public static void createClass(String classID, periodo) {
        def controller = new TurmaController()
        controller.params << [classID:classID, periodo:periodo]
        controller.createAndSaveTurma()
        controller.response.reset()
    }

    public static Turma getTurma(String classID, String periodo) {
        def controller = new TurmaController()
        controller.params << [classID:classID, periodo: periodo]
        return controller.getTurma()
    }

    public static boolean compatibleTo(String classID, String periodo, Turma cl) {
        if (classID == cl.classID && periodo == cl.periodo) return true
        return false
    }

    public static boolean onlyTurma(String classID, String periodo) {
        def controller = new TurmaController()
        controller.params << [classID:classID, periodo: periodo]
        return controller.onlyTurma()
    }

    public static saveCopy(String classID, String periodo) {
        def controller = new TurmaController()
        controller.params << [classID:classID, periodo: periodo]
        controller.saveCopy()

    }

    public static boolean createClassWithStudents(String classID, String periodo, List students) {
        def controller = new TurmaController()
        controller.params << [classID:classID, periodo:periodo, students:students]
        controller.createAndSaveTurma()
        controller.response.reset()
    }

    public static addStudent(Long idStudent, Long idTurma){
        def student = Student.findById(idStudent)
        def turma = Turma.findById(idTurma)

        List<Student> students = turma.getStudents()
        if (!students){
            students = []
        }
        students.add(student)
        turma.setStudents(students)
    }
}
