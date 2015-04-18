package pages

import geb.Page

class RegisterEvaluationPage extends Page {
    static url = "evaluation/register"

    static at = {
        title ==~ /Criar Avaliação/
    }

        // Could parametrize, obtaining data from class TestDataAndOperations
    }

    def fillData(elementId, text) {
    	elementId = ("#" + elementId)
        $(elementId).val(text)
    }

    def click(elementId) {
    	elementId = ("#" + elementId)
    	$(elementId).click()
    }

}