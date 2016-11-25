package pages.ConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class AddConceptPage extends Page{
    static url = "/TA/concept/create"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('concept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.create.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
    }

    def fillConceptDetails(String nome){
        $("form").nome = nome
    }

    def selectCreate(){
        $("input", name: "create").click()
    }

}
