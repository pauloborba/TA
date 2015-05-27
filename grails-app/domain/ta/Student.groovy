package ta

class Student {
    String login
    String name
    HashMap<EvaluationCriterion, String> evaluationCriteria = new HashMap<>()

    static constraints = {
        login unique: true
        name blank: false
    }

    public void afterCreateAddCriteria(List<EvaluationCriterion> evaluationCriteria) {
        for(EvaluationCriterion evaluationCriterion : evaluationCriteria) {
            this.evaluationCriteria.put(evaluationCriterion, "")
        }
    }

    public void addCriterion(EvaluationCriterion evaluationCriterion) {
        if(evaluationCriteria.get(evaluationCriterion) == null) {
            evaluationCriteria.put(evaluationCriterion, "")
        }
    }
}
