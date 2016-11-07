package pages.ClassPages

import geb.Page

/**
 * Created by dquei on 10/25/2016.
 */
class CreateClassPage extends Page{

    static url = "turma/create"


    static at = {
        title ==~ /Create Turma/
    }

    def fillClassDetails(String id, String periodo){
        $("form").classID = id
        $("form").periodo = periodo
    }

    def selectCreateClass(){
        $("input", name: "create").click()
    }

    def boolean checkForErrors() {
        return $("ul", class: "errors").isDisplayed()
    }
}
