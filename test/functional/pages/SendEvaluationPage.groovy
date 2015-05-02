package pages

import geb.Page
import data.EvaluationData

class SendEvaluationPage extends Page {
    static url = "evaluation/send"

    static at = {
        title ==~ /enviar avaliação/
    }

  static content = {
        send {
            $ ('input.send')
        }
    }
}
