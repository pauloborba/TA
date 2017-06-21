package pages

/**
 * Created by Ricardo on 6/13/2017.
 */

import geb.Page


class EnviarEmailAutoAvaliacao extends Page{
    static url = "turma/enviarEmailAutoAvaliacao"

    static at = {
        title ==~ /Enviar Email/
    }
}
