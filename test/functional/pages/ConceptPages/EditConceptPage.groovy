package pages.ConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class EditConceptPage extends Page{
    static link = "/TA/concept/edit"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('concept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.edit.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
    }

    def fillConceptName(String novo){
        $("form").nome = novo
    }

    def btnUpdateConcept(){
        $("input", name: "_action_update").click()
    }

}
