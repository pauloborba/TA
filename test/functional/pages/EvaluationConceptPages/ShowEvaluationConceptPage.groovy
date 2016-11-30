package pages.EvaluationConceptPages

import pages.PageWithInternationalization

class ShowEvaluationConceptPage extends PageWithInternationalization{
    static url = "TA/evaluationConcept/show/"

    static at = {
        def evalConceptLabel = internationalizationHelper.getMessage('evaluationConcept.label')
        title == internationalizationHelper.getMessage('default.show.label', evalConceptLabel)
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
