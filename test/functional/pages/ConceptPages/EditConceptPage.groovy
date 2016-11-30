package pages.ConceptPages

import pages.PageWithInternationalization

class EditConceptPage extends PageWithInternationalization{
    static url = "/TA/concept/edit"

    static at = {
        def conceptLabel = internationalizationHelper.getMessage('concept.label')
        title == internationalizationHelper.getMessage('default.edit.label', conceptLabel)
    }

    def fillConceptName(String novo){
        $("form").nome = novo
    }

    def btnUpdateConcept(){
        $("input", name: "_action_update").click()
    }

}
