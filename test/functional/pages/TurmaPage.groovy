package pages

import geb.Page

/**
 * Created by wfmf on 13/06/2017.
 */
class TurmaPage extends Page {
    static url = "/TA/turma/create"

    static at = {
        title ==~ /Create Turma/
    }

    boolean createAndSaveClass(className) {
        $("form").nome = className
        $("input", name: "create").click()
    }
}
