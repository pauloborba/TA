package pages

import geb.Page

class RegisterEvaluationPage extends Page {
    static url = "/TA/evaluation/create"

    static at = {
        String model = "Evaluation"
        String msg = GetPageTitle.getMessage("default.create.label", "Evaluation")
        title ==~ msg
        //title ==~ /Criar Evaluation/
//        title ==~ /Create Evaluation/
    }

    def fillData(text) {
        $("form").title = text
    }

    def click(){
        $("input", name: "create").click()
    }

}