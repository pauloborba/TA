package pages

import geb.Page

/**
 * Created by Lapp on 25/06/2016.
 */
class ShowEvaluationPage extends Page {
    static url = "evaluation/show"

    static at = {
        title ==~ /Ver Create property/
    }

    def selectDeleteEvaluation() {
        withConfirm {$("input", class: "delete").click()}
    }
}
