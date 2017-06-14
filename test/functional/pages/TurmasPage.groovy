package pages

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class TurmasPage extends Page{
    static url = "turma"

    static at = {
        title ==~ /Turma/
    }

    def selecionaTurma(String nomeTurma) {
        $("a",text: nomeTurma).click()
    }
}
