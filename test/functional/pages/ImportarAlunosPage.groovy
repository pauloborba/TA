package pages

import geb.Page

/**
 * Created by wfmf on 13/06/2017.
 */
class ImportarAlunosPage extends Page {
    static url = "/TA/aluno/importAlunos"
    static turmaPage = new TurmaPage()

    static def selectClass() {
        $('select').click()
    }
}
