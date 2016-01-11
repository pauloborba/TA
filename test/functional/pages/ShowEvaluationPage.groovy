package pages

import geb.Page

class ShowEvaluationPage extends Page{

    static url = "/TA/evaluation/show"

    static at = {
        String model = "Evaluation"
        String msg = GetPageTitle.getMessage("default.show.label", "Evaluation")
        title ==~ msg
    }
}