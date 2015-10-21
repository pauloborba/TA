
package pages.DisciplinePages

import geb.Page

class RegisterNewDisciplinePage extends Page {

    static url = "TA/Discipline/Register"

    static at = {
        tittle ==~ /Register New Discipline/
    }

    def fillDisciplineForm(String name, String teacher, String[] concepts) {
        $("form").name = name
        $("form").teacher = teacher
        $("form").concepts = concepts
    }
}