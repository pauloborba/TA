package ta

class EvaluationConcept {
    String name;
    int n_concepts;
    String[] concepts;

    static constraints = {
        name blank: false
    }
    //The default Evaluation Concept
    public EvaluationConcept(String name, int n_concepts) {
        this.name = name;
        this.n_concepts = n_concepts;
        this.concepts = name.split(", ");
    }
}
