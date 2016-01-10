package pages.EvaluationCriterionPages

import geb.Page
import pages.GetPageTitle

class EvaluationCriterionPage extends Page {

    static url = "/TA/evaluationCriterion/index"

    static at =  {
        String model = "EvaluationCriterion"
        String msg = GetPageTitle.getMessage("default.list.label", "EvaluationCriterion")
        title ==~ msg
        //title ==~ /EvaluationCriterion Listagem/
//        title ==~ /EvaluationCriterion List/
    }
}
