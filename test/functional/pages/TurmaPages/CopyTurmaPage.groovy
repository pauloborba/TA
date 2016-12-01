package pages.TurmaPages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class CopyTurmaPage extends Page{

    static url = "turma/copy/1"


    static at = {
        title ==~ /Edit Turma/
    }

    def fillTurmaDetails(String classID, String periodo){
        $("form").classID = classID
        $("form").periodo = periodo
    }

    def copyTurma(){
        $("input", name: "_action_saveCopy").click()
    }

    def boolean checkForErrors() {
        return $("ul", class: "errors").isDisplayed()
    }
}
