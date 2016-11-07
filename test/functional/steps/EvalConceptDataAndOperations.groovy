package steps

import ta.ConceptController
import ta.EvaluationConcept
import ta.EvaluationConceptController
import ta.Concept

/**
 * Created by João Vasconcelos on 02/11/2016.
 */
class EvalConceptDataAndOperations {
    public static void createEvalConcept(String nome, List<String> conceitos){
        List l_conceitos = []
        for(conceito in conceitos){
            Concept concept = new Concept(conceito)
            l_conceitos.add(concept)
        }
        def e_controller = new EvaluationConceptController()
        e_controller.params << [nome: nome, conceitos: l_conceitos]
        e_controller.saveEvalCon()
        e_controller.response.reset()
    }

    public static updateEvalConcept(EvaluationConcept novo){
        def e_controller = new EvaluationConceptController()
        e_controller.params.id = novo.id
        e_controller.updateEvalCon()
    }
}
