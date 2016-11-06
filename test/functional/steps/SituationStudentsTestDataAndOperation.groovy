package steps

import ta.Student
import ta.StudentController
/**
 * Created by lavinia on 06/11/2016.
 */
class SituationStudentsTestDataAndOperation {

    public static void AddStudentAndCriterion(String nome, String login, String descricao){
        AddStudentsTestDataAndOperations.createStudent(nome,login)
        CriterionTestDataAndOperations.createCriterion(descricao)
    }
}
