package pages.ConceptPages

import geb.Page

class ConceptPage extends Page {
    static url = "/TA/concept/index"

    static at = {
        title ==~ /Concept List/
    }

    boolean validFormat

    def fillData(text) {
        $("form").title = text
    }

    def click(){

    }

    def update(){

    }

    def importSheet(file){

    }

    def displayError(){

    }

}