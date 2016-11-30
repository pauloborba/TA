package pages.ConceptPages

import pages.PageWithInternationalization

class ShowConceptPage extends PageWithInternationalization {
    static url = "/TA/concept/show"

    static at = {
        def conceptLabel = internationalizationHelper.getMessage('concept.label')
        title == internationalizationHelper.getMessage('default.show.label', conceptLabel)
    }

    def editButton(){
        $("a", class: "edit").click()
    }

    def matchConcept(String concept){
        return $("span", class: "property-value").text() == concept
    }
}
