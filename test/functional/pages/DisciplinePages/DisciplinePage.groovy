package pages.DisciplinePages

import geb.Page

class DisciplinePage extends Page {

    static url = "TA/Discipline/index"

    static at = {
        tittle ==~ /Discipline List/
    }
}