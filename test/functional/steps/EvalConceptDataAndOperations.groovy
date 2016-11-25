package steps

import ta.ConceptController
import ta.EvaluationConcept
import ta.EvaluationConceptController
import ta.Concept

/**
 * Created by João Vasconcelos on 02/11/2016.
 */
class EvalConceptDataAndOperations {
    public static void createEvalConcept(String name, List<String> concepts){
        Set<Concept> setConcepts = []
        for(concept in concepts){
            Concept newConcept = new Concept((concept))
            setConcepts.add(newConcept)
        }
        EvaluationConcept evalConcept = new EvaluationConcept(name, setConcepts)
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
