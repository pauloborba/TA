package pages

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class ShowTurmaPage extends Page{
    static url = "turma/show"

    static at = {
        title ==~ /Show Turma/
    }


    def boolean selecionaEnviarEmailAlunosComProblemas() {
        $("#enviarEmailAlunosComProblemas").click()
    }

    def boolean selecionaEnviarEmailAutoAvaliacao() {
        $("#enviarEmailAutoAvaliacao").click()
    }
}
