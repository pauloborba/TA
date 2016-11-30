package pages.ConceptPages

import pages.PageWithInternationalization

class AddConceptPage extends PageWithInternationalization{
    static url = "/TA/concept/create"

    static at = {
        def conceptLabel = internationalizationHelper.getMessage('concept.label')
        title == internationalizationHelper.getMessage('default.create.label', conceptLabel)
    }

    def fillConceptDetails(String nome){
        $("form").nome = nome
    }

    def selectCreate(){
        $("input", name: "create").click()
    }

}
