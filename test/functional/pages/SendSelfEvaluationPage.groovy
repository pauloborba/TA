package pages

import geb.Page
import data.SelfEvaluationData

class SendSelfEvaluationPage extends Page {
    static url = "evaluation/selfevaluation"

    static at = {
        title ==~ /preencher auto-avaliação/
    }

  static content = {
        send {
            $ ('input.send')
        }
	
    }


    def add (String Selfevaluation) {
        def selfevaluation = SelfEvaluationData.findByTitle (Selfevaluation)

        if (selfevaluation.name == Selfevaluation) {
            $ ("form").student = selfevaluation.student
        }
        $ ("form").name = Selfevaluation

        send.click ()
    } 
}
