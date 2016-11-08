package ta

class Concept {
    String nome;
    static belongsTo = EvaluationConcept

    static constraints = {
        nome unique: true
    }

    public Concept(String nome){
        this.nome = nome;
    }
}
