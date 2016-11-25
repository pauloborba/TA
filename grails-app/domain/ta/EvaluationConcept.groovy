package ta

class EvaluationConcept {
    String nome;
    static hasMany = [conceitos: Concept]

    static constraints = {
        nome blank: false, unique: true;
        conceitos validator: {val, obj ->
            def retval = true
            if(!obj?.conceitos?.size()){
                retval = 'conceitos.validator.hasnoconcepts.error'
            }
            return retval
        }
    }

    EvaluationConcept(String nome, Set<Concept> concepts){
        this.nome = nome;
        this.conceitos = concepts;
    }

    List<String> allConcept(){
        List<String> ret = [];
        for(c in conceitos){
            ret << c.nome;
        }
        ret;
    }

    public setNome(String nome){
        this.nome = nome;
    }
}
