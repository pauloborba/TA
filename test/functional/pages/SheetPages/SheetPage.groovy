package pages.SheetPages

import geb.Page

class SheetPage extends Page {
    static url = "/TA/sheet/index"

    static at = {
        title ==~ /Sheet List/
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
