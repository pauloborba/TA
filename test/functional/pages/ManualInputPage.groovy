package pages

import geb.Page

class ManualInputPage extends Page {

    static url = "/TA/student/manualInput"

    static at = {
        title ==~ /Manual Sheet Input/
    }

    def fillConceptDetails(concept, description) {
        $("form").concept = concept;
        $("form").description = description;
    }

    def Input(){
        $("#capeta").click()
    }

}
