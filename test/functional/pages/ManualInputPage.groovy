package pages

import geb.Page

class ManualConceptInputPage extends Page{
    static url = "/TA/manual/index"

    static at = {
        title ==~ /Manual Concept Input/
    }

    def choose(cell){}

    def fillConceptDetails(concept, description) {
        $("form").concept = concept;
        $("form").description = description;
    }

    def click(){}

    def update(){ }

    def displayError(){ }
    
    def checkCriteria(){}
    
    def checkStudents(){}
    
    }
}
