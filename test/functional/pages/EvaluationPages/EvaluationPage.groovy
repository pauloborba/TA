package pages.EvaluationPages

import geb.Page
import ta.Evaluation
/**
 * Created by Danilo on 23/06/2016.
 */
class EvaluationPage extends Page {

    static url = "/TA/evaluation/index"

    static at =  {
        title ==~ /Create property Listagem/
    }

    boolean confirmEvalaution(String criterionName,String evaluationOrigin,Date evaluationDate) {
        boolean r = false
        boolean findName = $("tr").find("td").has("a",text: criterionName)
        boolean findLogin = $("tr").has("td",text: evaluationOrigin)
        boolean findEvaluationDate = $("tr").has("td",text: evaluationDate)
        if(findName && findLogin && findEvaluationDate){
            r = true
        }
        return r
    }

    def NoExistEvaluation() {
        Evaluation.list().size()
    }

    def sendCriterion(){
        $("a", class: "sendEmail").click()
    }

    def needEmail() {
        $("div.message").text()
    }
}