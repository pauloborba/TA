package ta

class Student {
    String login
    String name
    HashMap<EvaluationCriterion, String> evaluationCriteria = new HashMap<>()

    static constraints = {
        login unique: true
        name blank: false
    }
}
