package pages.EvaluationConceptPages

import geb.Page

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class EditEvaluationConceptPage extends Page{
    static url = "TA/evaluationConcept/edit/"

    static at = {
        title ==~ /Editar EvaluationConcept/
        //title ==~ /Edit EvaluationConcept/
    }

    def editEvalConceptWithoutConcept(){
        $("input", name: "_action_update").click()
    }

    def editEvalConcept(String anterior){

    }

}
