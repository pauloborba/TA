package pages.ClassPages

import geb.Page
/**
 * Created by Avell on 13/06/2017.
 */
class CreateClassPage extends Page{
    static url = "class/create"

    static at = {
        title ==~ /Create Class/
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
