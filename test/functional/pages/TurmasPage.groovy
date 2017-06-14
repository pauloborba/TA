package page

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class TurmasPage extends Page{
    static url = "turma"

    static at = {
        title ==~ /TurmasPage/
    }

    def selecionaTurma(String nomeTurma) {
        $("a:contains('"+nomeTurma+"')").click()
    }

    def boolean selecionaEnviarEmailAlunosComProblemas() {
        $("#enviarEmailAlunosComProblemas").click()
    }

    def boolean selecionaEnviarEmailAutoAvaliacao() {
        $("#enviarEmailAutoAvaliacao").click()
    }
}
