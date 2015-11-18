package ta

class Student {
    String login
    String name

    // tentei um enumerador primeiro mas da erro
    static class Concept {
        public static final List<String> CONCEPTS = ["MA", "MPA", "MANA", "XX"]
    }


    Map<String, String> evaluations
    Map<String, String> AutoEvaluations

    static constraints = {
        login unique: true
        name blank: false
    }

    public void afterCreateAddCriteria(List<EvaluationCriterion> evaluationCriteria) {
        evaluations = new HashMap<>()
        for(EvaluationCriterion evaluationCriterion : evaluationCriteria) {
            if(this.evaluations.get(evaluationCriterion.name) == null) {
                this.evaluations.put(evaluationCriterion.name, Concept.CONCEPTS.get(3))
            }
        }
    }

    public void afterCreateAddAutoCriteria(List<AutoEvaluationCriterion> autoEvaluationCriteria) {
        AutoEvaluations = new HashMap<>()
        for(AutoEvaluationCriterion autoEvaluationCriterion : autoEvaluationCriteria) {
            if(this.AutoEvaluations.get(autoEvaluationCriterion.name) == null) {
                this.AutoEvaluations.put(autoEvaluationCriterion.name, Concept.CONCEPTS.get(3))
            }
        }
    }

    public void addCriterion(EvaluationCriterion evaluationCriterion) {
        if(evaluations == null) {
            evaluations = new HashMap<>()
        }
        if(this.evaluations.get(evaluationCriterion.name) == null) {
            this.evaluations.put(evaluationCriterion.name, Concept.CONCEPTS.get(3))
        }
    }

    public void addAutoCriterion(AutoEvaluationCriterion autoEvaluationCriterion) {
        if(AutoEvaluations == null) {
            AutoEvaluations = new HashMap<>()
        }
        if(this.AutoEvaluations.get(autoEvaluationCriterion.name) == null) {
            this.AutoEvaluations.put(autoEvaluationCriterion.name, Concept.CONCEPTS.get(3))
        }
    }
}
