package pages.EvaluationConceptPages

import geb.Page

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class ShowEvaluationConceptPage extends Page{
    static url = "TA/evaluationConcept/show/"

    static at = {
        title ==~ /Ver EvaluationConcept/
        //title ==~ /Show EvaluationConcept/
    }

    def editConcept(){
        $("a", class: "edit").click()
    }

    def testConcepts(String[] concepts){
        def b = $("a", class: "concepts").allElements()
        if(b.size() == concepts.size()) {
            b.sort({it.getText()})
            for(int i = 0; i < concepts.size(); ++i){
                if(concepts[i] != b[i]) return false
            }
            return true
        }
        return false
    }
}
