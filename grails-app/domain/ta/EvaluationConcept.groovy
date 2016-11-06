package ta

class EvaluationConcept {
    String nome;
    static hasMany = [conceitos: Concept]

    static constraints = {
        nome blank: false, unique: true;
    }

    List<String> allConcept(){
        List<String> ret = [];
        for(c in conceitos){
            ret << c.nome;
        }
        ret;
    }
}
