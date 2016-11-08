package pages.EvaluationConceptPages

import geb.Page

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class AddEvaluationConceptPage extends Page{
    static url = "/TA/evaluationConcept/create"

    static at = {
        title ==~ /Criar EvaluationConcept/
//        title ==~ /Create EvaluationConcept/
    }


    def fillNameEvalCon(String nome){
        $("form").nome = nome
    }

    def selectConcepts(String[] l_conceitos){
        $("form").conceitos = ["MA", "MPA", "MANA"]
    }

    def createEvalConcept(){
        $("input", name: "create").click()
    }
}
