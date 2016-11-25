package pages.ConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class ShowConceptPage extends Page {
    static link = "/TA/concept/show"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('concept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.show.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
    }

    def editButton(){
        $("a", class: "edit").click()
    }

    def matchConcept(String concept){
        return $("span", class: "property-value").text() == concept
    }
}
