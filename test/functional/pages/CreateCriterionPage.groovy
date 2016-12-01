package pages

import geb.Page
import ta.Turma
import steps.ClassTestDataAndOperations
import ta.Criterion

/**
 * Created by lapp on 07/05/2016.
 */


class CreateCriterionPage extends Page {

    static url = "criterion/create"

    static at = {
        title ==~ /Create Criterion/
    }

    def createCriterion(desc, classID, periodo) {
        chooseTurma(classID, periodo)
        $("form").description = desc
        $("input", name: "create").click()
    }

    def chooseTurma(String classID, String periodo) {
        //$("select", id: "criterion").click()
        def t = Turma.findByClassIDAndPeriodo(classID, periodo)
        $("select", id: "turma").value(t.id.toString())
    }

    def fillCriterionDetails(String desc){
        $("form").description = desc
    }

    def selectCreateCriterion(){
        $("input", name: "create").click()
    }

    def boolean checkForErrors() {
        return $("ul", class: "errors").isDisplayed()
    }
}