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
        return valid;
    }

    def update(){

    }

    def importSheet(file){

    }

    def hasMessage(){
        return isNullOrEmpty(getClassText("message"))
    }

    def hasErrors(){
        return isNullOrEmpty(getClassText("errors"))
    }

    private boolean isNullOrEmpty(String text) {
        boolean has = text != null && text != ""
        return has
    }

    private String getClassText(String className) {
        className = '.' + className
        String text = $(className).text()
        return text
    }

}