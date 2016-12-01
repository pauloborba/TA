package pages

import geb.Page
import ta.Turma

/**
 * Created by TMB on 23/06/2016.
 */
class AddGroupCriteriaPage extends Page {
    static url = "criterion/createGroup"

    static at = {
        title ==~ /Import Criterion/
    }

    def fillGroupCriteriaDetails(String description, String classID, String periodo){
        chooseTurma(classID, periodo)
        $("form").description = description
    }

    def selectAddGroupCriteria(){
        $("input", name: "create").click()
    }

    def chooseTurma(String classID, String periodo) {
        //$("select", id: "criterion").click()
        def t = Turma.findByClassIDAndPeriodo(classID, periodo)
        $("select", id: "turma").value(t.id.toString())
    }
}
