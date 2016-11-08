package pages.ConceptPages

import geb.Page

/**
 * Created by João Vasconcelos on 07/11/2016.
 */
class EditConceptPage extends Page{
    static link = "/TA/concept/edit"

    static at = {
        title ==~ /Edit Concept/
//        title ==~ /Editar Concept/
    }

    def fillConceptName(String novo){
        $("form").nome = novo
    }

    def btnUpdateConcept(){
        $("input", name: "_action_update").click()
    }

}
