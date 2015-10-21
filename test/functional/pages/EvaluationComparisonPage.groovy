package pages

import geb.Page

class EvaluationComparisonPage extends Page{
    static url = "/TA/EvaluationComparison/"

    static at = {
        title ==~ /Evaluation Comparison/
    }

    def click(){
        $("input", name:"compare").click()
    }
}
