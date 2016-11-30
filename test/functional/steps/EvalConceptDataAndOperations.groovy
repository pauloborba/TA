package steps

import ta.ConceptController
import ta.EvaluationConcept
import ta.EvaluationConceptController
import ta.Concept

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

    public static deleteConcept(String conceptName){
        def c_controller = new ConceptController()
        def conceptInstance = Concept.findByNome(conceptName)
        c_controller.delete(conceptInstance)
        c_controller.response.reset()
    }

    public static deleteEvaluationConcept(String evaluationConceptName){
        def e_controller = new EvaluationConceptController()
        def evaluationConceptInstance = EvaluationConcept.findByNome(evaluationConceptName)
        e_controller.delete(evaluationConceptInstance)
        e_controller.response.reset()
    }
}
