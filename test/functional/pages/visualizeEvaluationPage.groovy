package pages

import geb.Page

class VisualizeEvaluationPage extends Page {
    static url = "evaluation/visualize"

    static at = {
        title ==~ /visualizar Avaliação/
    }

  
  
    def click(elementId) {
    	elementId = ("#" + elementId)
    	$(elementId).click()
    }

    def search(title) {
        fillData("title", title)
        click("search")
    }
}
