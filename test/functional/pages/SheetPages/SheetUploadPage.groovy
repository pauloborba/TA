package pages.SheetPages

import commom.SheetImporter
import geb.Page
import ta.SheetController

import java.util.prefs.Preferences

class SheetUploadPage extends Page {
    static url = "/TA/sheet/upload"

    static at = {
        title ==~ /Upload Sheet/
    }

    boolean validFileFormat


    def click(){
        //$("input", name:"datafile").click()
        //$("input", name:"open").click()
        $("input", name:"submit").click()
        System.out.println($("submitButton", value:"submit"))

//        $("form", id: "p")
    }

    def submit(String filepath){
        File file = new File(filepath)

        $("form").datafile = file.absolutePath
        $("input", name:"submit").click()
    }

    def verifyFileFormat(String filepath){
        boolean valid = true;
        try {
            SheetImporter sheetImporter = new SheetImporter(filepath)
        } catch (IllegalArgumentException e){
            valid = false
        }
        //Sheet sheet = new Sheet()
        //sheet.filename = $("input", name:"datafile").value()
        //validFileFormat = sheet.validFileFormat()
        //System.out.println(validFileFormat)
        return valid;
    }

    def update(){

    }

    def importSheet(file){

    }

    def hasMessage(){
        boolean has = $("div", class:"message").text() != null
        return has
    }

    def hasErrors(){
        boolean has = $("div", class:"errors").text() != null
        return has
    }

}