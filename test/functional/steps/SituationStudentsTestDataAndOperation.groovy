package steps

import ta.EvaluationsByCriterion
import ta.SituationStudentsController
import ta.Student
import ta.StudentController

/**
 * Created by lavinia on 06/11/2016.
 */
class SituationStudentsTestDataAndOperation {

    public List<EvaluationsByCriterion> puxarLista(String aluno){
        Student estudante = Student.findByName(aluno)
        List<EvaluationsByCriterion> lista = estudante.criteriaAndEvaluations
        return lista
    }


}
