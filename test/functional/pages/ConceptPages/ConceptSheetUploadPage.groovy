package pages.ConceptPages

import geb.Page
import ta.ConceptController
import ta.Sheet

import java.util.prefs.Preferences

class ConceptSheetUploadPage extends Page {
    static url = "/TA/concept/upload"

    static at = {
        title ==~ /Upload Sheet/
    }

    boolean validFileFormat

    def fillData(text) {
        $("form").title = text
    }

    def click(){
        //$("input", name:"datafile").click()
        //$("input", name:"open").click()
        $("input", name:"submit").click()
        System.out.println($("submitButton", value:"submit"))

//        $("form", id: "p")
    }

    def verifyFileFormat(){
        Sheet sheet = new Sheet()
        sheet.filename = $("input", name:"datafile").value()
        validFileFormat = sheet.validFileFormat()
        System.out.println(validFileFormat)

    }

    def update(){

    }

    def importSheet(file){

    }

    def hasDisplayedError(){
        boolean has = $("div", class:"message").text() != null
        return has
    }

}