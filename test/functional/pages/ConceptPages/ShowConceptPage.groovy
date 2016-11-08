package pages.ConceptPages

import geb.Page

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class ShowConceptPage extends Page {
    static link = "/TA/concept/show"

    static at = {
        //title ==~ /Show Concept/
        title ==~ /Ver Concept/
    }

    def editButton(){
        $("a", class: "edit").click()
    }

    def matchConcept(String concept){
        return $("span", class: "property-value").text() == concept
    }
}
