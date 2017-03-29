package ta


import org.apache.ivy.core.settings.Validatable

import java.text.SimpleDateFormat
import java.lang.*
import ta.Evaluation
import ta.EvaluationsByCriterion
import ta.Student

class SituationStudentsController {

    def index() {
        //params.max = Math.min(max ?: 100, 100)
        respond Student.list(params), model: [studentInstanceCount: Student.count(), criterionInstanceCount: Criterion.count()]

    }


    public List<EvaluationsByCriterion> listaCriterios(String aluno){
        Student estudante = Student.findByName(aluno)
        List<EvaluationsByCriterion> lista = estudante.criteriaAndEvaluations
        return lista
    }
}
