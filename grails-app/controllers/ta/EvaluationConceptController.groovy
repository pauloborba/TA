package ta

class EvaluationConceptController {

    def index() { }

    def create(){
        respond new EvaluationConcept(params)
    }

    def show(EvaluationConcept evalConceptInstance) {
        respond evalConceptInstance
    }

    def save(EvaluationConcept evalConceptInstance){
        evalConceptInstance.save flush:true
    }
}
