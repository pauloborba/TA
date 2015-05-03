package steps

import ta.EvaluationCriterionController

class EvaluateStudentsTestDataAndOperations {

    // Tipo evaluationCriterion statico usado para comparar
    static evaluationCriteria = [
            [name: "Requirements"],
            [name: "Configuration management"],
            [name: "SaaS application architecture"],
            [name: "Project management"]
    ]

    static public def findEvaluationCriterionByName(String name) {
        evaluationCriteria.find { evaluationCriterion ->
            evaluationCriterion.name == name
        }
    }

    public static void createCriterion(criterionName) {
        def evController = new EvaluationCriterionController()
        evController.params << findEvaluationCriterionByName(criterionName)
        evController.create()
        evController.save()
        evController.response.reset()
    }
}
