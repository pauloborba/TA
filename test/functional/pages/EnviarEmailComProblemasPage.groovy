package pages

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class EnviarEmailComProblemasPage extends Page{
    static url = "turma/enviarEmailAlunosComProblemas"

    static at = {
        title ==~ /Enviar Email/
    }
}
