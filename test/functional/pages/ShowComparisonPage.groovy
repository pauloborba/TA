package pages

import geb.Page

class ShowComparisonPage extends Page{

    static url = "/TA/student/compare"

    static at = {
        title ==~ /Show Comparison/
    }
}
