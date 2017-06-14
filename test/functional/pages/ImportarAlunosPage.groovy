package pages

import geb.Page

/**
 * Created by wfmf on 13/06/2017.
 */
class ImportarAlunosPage extends Page {
    static url = "/TA/aluno/importAlunos"

    static at = {
        title ==~ /Importar Alunos/
    }

    boolean importWithoutFile() {
        $("input", name: "upload").click()
    }

    boolean openFileDialog() {
        $("input", name: "sheet").click()
    }
}
