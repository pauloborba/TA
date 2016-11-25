package pages.EvaluationConceptPages

import geb.Page
import grails.plugin.remotecontrol.RemoteControl

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class ShowEvaluationConceptPage extends Page{
    static url = "TA/evaluationConcept/show/"

    static at = {
        RemoteControl remoteControl = new RemoteControl()
        def entityName =  remoteControl.exec {
            ctx.messageSource.getMessage('evaluationConcept.label', null, Locale.getDefault())
        }
        def titleLabel = remoteControl.exec {
            ctx.messageSource.getMessage('default.show.label', [entityName] as Object[], Locale.getDefault())
        }
        title == titleLabel
    }

    def editEvalConcept(){
        $("a", class: "edit").click()
    }

    def testConcepts(String[] concepts){
        def b = $("a", class: "concepts").allElements()
        if(b.size() == concepts.size()) {
            b.sort({it.getText()})
            for(int i = 0; i < concepts.size(); ++i){
                if(concepts[i] != b[i].getText()) return false
            }
            return true
        }
        return false
    }

    def btnEditConcept(String concept){
        def b = $("a", class: "concepts").allElements()
        for(links in b){
            if(links.getText() == concept){
                links.click()
                break
            }
        }
    }
}
