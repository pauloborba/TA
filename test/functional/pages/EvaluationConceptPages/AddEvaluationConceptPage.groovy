package pages.EvaluationConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class AddEvaluationConceptPage extends Page{
    static url = "/TA/evaluationConcept/create"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('evaluationConcept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.create.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
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
