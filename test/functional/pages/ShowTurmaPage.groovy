package pages

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class TurmasPage extends Page{
    static url = "turma"

    static at = {
        title ==~ /Create property List/
    }

    def selecionaTurma(String nomeTurma) {
        $("a",text: nomeTurma).click()
    }

    def boolean selecionaEnviarEmailAlunosComProblemas() {
        $("#enviarEmailAlunosComProblemas").click()
    }

    def boolean selecionaEnviarEmailAutoAvaliacao() {
        $("#enviarEmailAutoAvaliacao").click()
    }
}
