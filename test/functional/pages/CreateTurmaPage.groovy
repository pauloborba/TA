package pages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class CreateTurmaPage extends Page{

    static url = "/TA/turma/create"


    static at = {
        title ==~ /Create Turma/
    }

    def fillTurmaDetails(String id, String periodo){
        $("form").classID = id
        $("form").periodo = periodo
    }

    def selectCreateTurma(){
        $("input", name: "create").click()
    }

    def boolean checkForErrors() {
        return $("ul", class: "errors").isDisplayed()
    }
}

