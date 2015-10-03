package pages

import geb.Page

class ShowComparisonPage extends Page{

    static url = "/TA/EvaluationComparison/show"

    static at = {
        title ==~ /Show Comparison/
    }
}