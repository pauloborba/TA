package pages

import geb.Page

/**
 * Created by wfeli on 13/06/2017.
 */
class ImportarAlunosPage extends Page {
    static url = "/TA/aluno/importAlunos"
    static turmaPage = new TurmaPage()

    static def selectClass() {
        $('select').click()
    }

    static def createAndSaveClass(String className) {
        $('input').nome = className
        $('#create').click()
    }
}
