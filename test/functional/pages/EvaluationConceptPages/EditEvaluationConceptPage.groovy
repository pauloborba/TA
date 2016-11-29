package pages.EvaluationConceptPages

import pages.PageWithInternationalization

class EditEvaluationConceptPage extends PageWithInternationalization{
    static url = "TA/evaluationConcept/edit/"

    static at = {
        def evalConceptLabel = internationalizationHelper.getMessage('evaluationConcept.label')
        title == internationalizationHelper.getMessage('default.edit.label', evalConceptLabel)
    }

    def editEvalConceptWithoutConcept(){
        $("input", name: "_action_update").click()
    }
}
