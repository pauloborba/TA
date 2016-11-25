package pages.EvaluationConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class EditEvaluationConceptPage extends Page{
    static url = "TA/evaluationConcept/edit/"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('evaluationConcept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.edit.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
    }

    def editEvalConceptWithoutConcept(){
        $("input", name: "_action_update").click()
    }

    def editEvalConcept(String anterior){

    }

}
