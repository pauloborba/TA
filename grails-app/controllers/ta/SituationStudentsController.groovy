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

    public void addEvaluationsToStudentTests(String studentLogin, LinkedList<Evaluation> evaluationList){
        for (int i = 0; i < Student.list().size(); i++) {
            if(Student.list().get(i).login.equals(studentLogin)){
                Student.list().get(i).addEvaluation(evaluationList.get(0))
                Student.list().get(i).save(
                        flush: true,
                        failOnError: true
                )
            }
        }
    }
}
