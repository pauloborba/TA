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
        def evalConcept = new EvaluationConcept()
        evalConcept.nome = nome
        List l_conceitos = []
        for(conceito in conceitos){
            Concept concept = new Concept(conceito)
            evalConcept.addToConceitos(concept)
        }
        def e_controller = new EvaluationConceptController()
        e_controller.save(evalConcept)
        e_controller.response.reset()
    }

    public static updateEvalConcept(EvaluationConcept novo){
        def e_controller = new EvaluationConceptController()
        e_controller.update(novo)
        e_controller.response.reset()
    }
}
