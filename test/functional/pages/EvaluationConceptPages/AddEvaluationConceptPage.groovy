package pages.EvaluationConceptPages

import pages.PageWithInternationalization

class AddEvaluationConceptPage extends PageWithInternationalization{
    static url = "/TA/evaluationConcept/create"

    static at = {
        def evalConceptLabel = internationalizationHelper.getMessage('evaluationConcept.label')
        title == internationalizationHelper.getMessage('default.create.label', evalConceptLabel)
    }


    def fillNameEvaluationConcept(String nome){
        $("form").nome = nome
    }

    def selectConcepts(Set<String> l_conceitos){
        $("form").conceitos = l_conceitos.findAll()
    }

    def createEvalConcept(){
        $("input", name: "create").click()
    }
}
