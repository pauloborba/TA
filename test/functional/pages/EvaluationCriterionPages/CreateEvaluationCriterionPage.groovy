package pages.EvaluationCriterionPages

import geb.Page
import pages.GetPageTitle

class CreateEvaluationCriterionPage extends Page {

    static url = "/TA/evaluationCriterion/create"

    static at =  {
        String model = "EvaluationCriterion"
        String msg = GetPageTitle.getMessage("default.create.label", "EvaluationCriterion")
        title ==~ msg
//        title ==~ /Criar EvaluationCriterion/
//        title ==~ /Create EvaluationCriterion/
    }

    def fillEvaluationCriterionDetails(String name) {
        $("form").name = name
    }

    def selectCreateEvaluationCriterion() {
        $("input", name: "create").click()
    }
}
